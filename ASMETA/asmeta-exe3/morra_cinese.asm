asm morra_cinese

import StandardLibrary

// Morra cinese (Wikipedia)
// Lo scopo del gioco e' sconfiggere l'avversario scegliendo un segno
// in grado di battere quello dell'altro, secondo le seguenti regole:
// 1. Il sasso spezza le forbici (vince il sasso)
// 2. Le forbici tagliano la carta (vincono le forbici)
// 3. La carta avvolge il sasso (vince la carta)
// Se i due giocatori scelgono la stessa arma, il gioco e' pari e si gioca di nuovo.

// Questo modello ASM permette di giocare a morra cinese contro il computer.

signature:
	// DOMAINS
	enum domain Sign = {SCISSORS | ROCK | PAPER}
	enum domain Result = {WINFIRST | WINSECOND | PATTA}
	
	// FUNCTIONS
	dynamic monitored userChoice : Sign
	dynamic controlled computerChoice : Sign
	
	
	
	dynamic controlled outMess: String
	static playResult: Prod(Sign, Sign) -> Result
	
definitions:
	// DOMAIN DEFINITIONS

	// FUNCTION DEFINITIONS

	//La funzione e' completamente specificata.
	//Infatti, tutte le 9 combinazioni sono considerate.
	function playResult($s1 in Sign, $s2 in Sign) =
		if($s1=$s2) then //tre casi
			PATTA
		else
			switch($s1, $s2)
				case (SCISSORS, PAPER):
					WINFIRST
				case (PAPER, ROCK):
					WINFIRST
				case (ROCK, SCISSORS):
					WINFIRST
				otherwise //i tre casi rimanenti
					WINSECOND
			endswitch
		endif

	// RULE DEFINITIONS

	// INVARIANTS

	// MAIN RULE
	
	main rule r_Main = 
	//il computer sceglie in modo nondeterministico un segno
	choose $s in Sign with true do
		par
			computerChoice := $s //viene memorizzato il segno solo per vedere la giocata del computer nell'update set 
			switch(playResult(userChoice, $s))
				case WINFIRST:
					outMess := "Hai vinto!"
				case WINSECOND:
					outMess := "Ha vinto il computer."
				case PATTA:
					outMess := "Patta."
			endswitch
		endpar

// INITIAL STATE

default init s0:
	function outMess = ""

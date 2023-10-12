asm Dadi2

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	domain Dado subsetof Integer
	domain Soldi subsetof Integer
	enum domain Vincitore = {WINUSER | WINPC}
	enum domain Giocatore = {PC | USER}

	// FUNCTIONS
	controlled soldi : Giocatore -> Soldi
	
	controlled vincitore: Vincitore
	
	monitored mossaGiocatore: Dado
	
	derived isGameOver: Boolean
	

definitions:
	// DOMAIN DEFINITIONS
	domain Dado = {1:6}
	domain Soldi = {0:10}
	
	// FUNCTION DEFINITIONS
	function isGameOver = (soldi(PC) = 0 or soldi(USER) = 0)

	// RULE DEFINITIONS
	rule r_giocoDadi =
		choose $d in Dado with true do 
			if $d = mossaGiocatore then skip
			else if $d > mossaGiocatore then
				par
					soldi(PC):= soldi(PC) + 1
					soldi(USER) := soldi(USER) - 1
				endpar
			else
				par
					soldi(PC):= soldi(PC) - 1
					soldi(USER) := soldi(USER) + 1
				endpar
			endif
			endif
	
	rule r_vincitore =
		if soldi(PC) = 0 then vincitore := WINUSER else vincitore := WINPC endif

	// INVARIANTS
	
	// qualsiasi utente può avere un saldo tra 0 e 10
	CTLSPEC (forall $u in Giocatore with (forall $i in Soldi with ef(soldi($u)=$i)))
	
	// il giocatore USER può raggiunger 10
	CTLSPEC ef(soldi(USER)=10)

	// nel gioco ci sono sempre 10 euro
	CTLSPEC ag(soldi(USER) + soldi(PC) = 10)
	 
	// esiste un cammino dallo stato iniziale in cui l'importo del PC è sempre > 0
	CTLSPEC eg(soldi(PC)>0)
	
	// l'importo fi ogni giocatore è sempre tra 0 e 6
	CTLSPEC ag(0<=soldi(PC) and soldi(PC)<=6)

	// MAIN RULE
	main rule r_Main =
		if not isGameOver then
			r_giocoDadi[]
		else
			r_vincitore[]
		endif

// INITIAL STATE
default init s0:
	function soldi($s in Giocatore) = 5

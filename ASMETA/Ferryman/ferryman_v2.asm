// non flatter
asm ferryman_v2

//Problem: a ferryman must carry on the other bank of a river a wolf, a goat and
//a cabbage. He can carry them one at a time.
//There are two dangerous situations:
//- the wolf kills the goat if the ferryman is not on the same bank of the river;
//- the goat eats the cabbage if the ferryman is not on the same bank of the river;
//At the beginning all the actors are on the left bank of the river.

//This ASM model implements a correct beahaviour of the ferryman (no dangerous
//situations can happen).

//Differences with the model ferryman.asm: thanks to the derived function goodCouple
//the machine stops when all the actors are on the right bank.

//The simulations with AsmetaS must be executed with the -shuffle option
//(in order to activate the non deterministic choice in the choose rule) and
//with the -ne option (the simulation must stop when the update set is empty,
//that is when all the actors are on the right bank).


//Problema: un ferryman deve portare sull'altra sponda di un fiume un wolf, una
//goat ed un cabbage. Puo' trasportarne solo uno alla volta.
//Ci sono due situazioni di pericolo:
//il wolf mangia la goat se il ferryman non e' presente a controllare;
//la goat mangia il cabbage se il ferryman non e' presente a controllare.
//All'inizio sono tutti sulla sponda LEFT.

//Questo modello ASM dovrebbe essere l'implementazione di un comportamento
//corretto (che non porta a situazioni di pericolo) da parte del FERRYMAN.

//rispetto a ferryman.asm ha la derivata goodCouple e la macchina si ferma quando sono tutti
//sul lato destro

//la simulazione con AsmetaS deve essere lanciata con -shuffle (per attivare
//la scelta non deterministica delle choose) e -ne (la computazione deve terminare
//quando non ci sono piu' aggiornamenti: vuol dire che sono arrivati tutti a destra).

import ../StandardLibrary
import ../CTLlibrary

signature:
	enum domain Actors = {FERRYMAN | GOAT | CABBAGE | WOLF}
	enum domain Side = {LEFT | RIGHT}
	dynamic controlled position: Actors -> Side
	static goodCouple: Prod(Actors, Actors) -> Boolean // indica se una coppia di attori puo' rimanere sola
	derived goodSituationSide: Prod(Actors, Actors, Side) -> Boolean
	derived allOnRightSide: Boolean

definitions:
	//(GOAT, CABBAGE) and (GOAT, WOLF) are not good couples
	function goodCouple($a in Actors, $b in Actors) =
		/*not($a=GOAT and $b=CABBAGE) and not($b=GOAT and $a=CABBAGE) and
		not($a=WOLF and $b=GOAT) and not($b=WOLF and $a=GOAT)*/
		($a=GOAT implies ($b!=CABBAGE and $b!=WOLF)) and
		($b=GOAT implies ($a!=CABBAGE and $a!=WOLF))

	//a couple of actors can stay on the same bank alone just if they are a good couple
	function goodSituationSide($a in Actors, $b in Actors, $s in Side) =
		(position($a)=$s and position($b)=$s) implies goodCouple($a, $b)

	//all the actors are on the right bank
	function allOnRightSide =
		(forall $a in Actors with position($a) = RIGHT)
	
	rule r_travelLeftToRight =
		//if the ferryman is on the right bank, he must go for sure on the right bank
		if(position(FERRYMAN)= LEFT) then
			par
				position(FERRYMAN) := RIGHT
				
				//he chooses an actor such that all the actors that remains on the left bank are good couples
				choose $a in Actors with $a!=FERRYMAN and position($a) = LEFT and
						(forall $x in Actors, $y in Actors with (($x!=$a and $y!=$a) implies
													goodSituationSide($x, $y, LEFT))) do
					position($a) := RIGHT
			endpar
		endif
	
	rule r_travelRightToLeft =
		if(position(FERRYMAN)=RIGHT and not(allOnRightSide)) then
				par
					position(FERRYMAN) := LEFT

					//If there is an actor who can not stay alone with another one
					//on the right bank, the ferryman carries him with himself
					choose $c in Actors with $c!=FERRYMAN and position($c) = RIGHT
						and (exist $k in Actors with not(goodSituationSide($c, $k, RIGHT))) do
						position($c) := LEFT
				endpar
			endif
	
	//AsmetaL invariants
	invariant over position: position(GOAT)=position(CABBAGE) implies position(GOAT)=position(FERRYMAN)
	invariant over position: position(WOLF)=position(GOAT) implies position(WOLF)=position(FERRYMAN)

	//CTL properties
	//security properties
	CTLSPEC ag(position(GOAT)=position(CABBAGE) implies position(GOAT)=position(FERRYMAN))
	CTLSPEC ag(position(WOLF)=position(GOAT) implies position(WOLF)=position(FERRYMAN))

	//reachability property: all the actors will reach the right bank
	CTLSPEC ef(allOnRightSide)
	//CTLSPEC ef(position(WOLF)= RIGHT and position(GOAT)=RIGHT and position(CABBAGE)=RIGHT and position(FERRYMAN)=RIGHT)
	
	//When they are all on the right bank, the don't travel anymore
	//CTLSPEC not(ef(allOnRightSide and ag(allOnRightSide)))
	CTLSPEC not(ef(allOnRightSide))
	
	//This is the most precise property
	//CTLSPEC not(ef(allOnRightSide) and ag(allOnRightSide implies ag(allOnRightSide)))

	//reachability of a given setting: goat on the left; wolf, cabbage and ferryman on the right
	//CTLSPEC ef(position(WOLF)= RIGHT and position(GOAT)=LEFT and position(CABBAGE)=RIGHT and position(FERRYMAN)=RIGHT)
	//counterexample
	//CTLSPEC not(ef(position(WOLF)= RIGHT and position(GOAT)=LEFT and position(CABBAGE)=RIGHT and position(FERRYMAN)=RIGHT))

	//it is possible that the cabbage is alone on the right side
	CTLSPEC ef(position(WOLF)= LEFT and position(GOAT)=LEFT and position(CABBAGE)=RIGHT and position(FERRYMAN)=LEFT)

	
	main rule r_Main =
		par
			r_travelLeftToRight[]
			r_travelRightToLeft[]
		endpar

default init s0:
	function position($a in Actors) = LEFT

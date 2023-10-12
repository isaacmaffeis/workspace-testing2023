asm CoffeeMachine

//Una macchinetta automatica dispensa caffe', te' e latte. La macchinetta accetta solo
//monete da 50 centesimi e da 1 euro. Se viene inserita una moneta da 50 centesimi, la
//macchinetta dispensa latte (se disponibile); se viene inserita una moneta da 1 euro,
//invece, la macchinetta decide in modo casuale di dispensare caffe' o te' (se disponibili).
//Se viene dispensata una bevanda, la sua disponibilita' viene decrementata e la moneta
//viene conservata nella macchinetta.
//Nel modello ASM ogni passo di macchina corrisponde all'inserimento di una moneta
//e all'erogazione di una bevanda corrispondente.
//La macchina all'inizio contiene 10 unita' per ogni bevanda; l'atto di erogazione di
//una bevanda corrisponde alla diminuzione di un'unita' della disponibilita' della stessa
//e alla conservazione della moneta (nelle monete conservate, non bisogna distinguere
//tra monete da 50 centesimi ed 1 euro). Se la bevanda non e' disponibile, non viene
//erogata e la moneta non viene conservata.
//La macchina puo' contenere al massimo 25 monete; quando la macchina e' piena di
//monete, non accetta altre monete e, quindi, non eroga pie' alcuna bevanda. All'inizio
//la macchinetta non contiene alcuna moneta.
//L'utente del sistema decide ad ogni passo di simulazione il tipo di moneta da inserire.

import ../StandardLibrary
import ../CTLlibrary

signature:
	
	enum domain Product = {COFFEE | TEA | MILK}
	enum domain Coin = {FIFTY_CENT | ONE_EURO}
	enum domain Status = {WORKING | FULL_MONEY | EMPTY_PRODUCTS}
	domain Availability subsetof Integer
	domain Money_box subsetof Integer
	
	controlled availability : Product ->  Availability
	controlled money_box : Money_box
	controlled status : Status
	
	monitored user_coin: Coin
	
	derived isAvailable: Product -> Boolean
	derived isFullMoney: Boolean
	derived isEmpty: Boolean
	
	static max_coins: Money_box
	
definitions:
	domain Availability = {0 : 10}
	domain Money_box = {0 : 25}
	
	function max_coins = 25
	function isFullMoney = money_box = max_coins
	function isEmpty = (forall $p in Product with availability($p) = 0)
	function isAvailable($p in Product) = availability($p) != 0
		
	rule r_dispenser = 
		switch(user_coin)
		case FIFTY_CENT:
			if isAvailable(MILK) then
				par
					availability(MILK) := availability(MILK) - 1
					money_box := money_box + 1
				endpar
			endif
		case ONE_EURO:
			choose $p in Product with $p != MILK and isAvailable($p) do
				par
					availability($p) := availability($p) - 1
					money_box := money_box + 1
				endpar
		endswitch
		
	invariant inv_availability over availability : (forall $p in Product with availability($p) < 11 and availability($p)>=0)
	invariant inv_coins over money_box: money_box >= 0 and money_box < 26
	
	CTLSPEC ef(status=FULL_MONEY)
	
	CTLSPEC ag(status = WORKING implies money_box < 26)
	CTLSPEC ag(status = WORKING implies (exist $p in Product with availability($p)>0))
	CTLSPEC ag(status = FULL_MONEY implies money_box = 25)
	CTLSPEC ag(status = EMPTY_PRODUCTS implies (forall $p in Product with availability($p) = 0))
	
	main rule r_coffe_machine =
		switch(status)
			case WORKING:
			if isFullMoney then status := FULL_MONEY
			else if isEmpty then status := EMPTY_PRODUCTS
			else
				r_dispenser[]
			endif
			endif
		endswitch
		
default init s0:
	function status = WORKING
	function availability($p in Product) = 10
	function money_box = 0
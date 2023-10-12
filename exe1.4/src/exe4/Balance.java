package exe4;

public class Balance {
	
	private int p;
	private int w;
	
	Balance(){}
	
	public boolean setBalanceValue(int x, int y){
		this.p=x;
		this.w=y;
		
		if((p<4 && w<=400) || (p==0 && w<=1000))
			return true;
	 	else
		{
			return false;
		} 
	}
	
	public int getP(){
		return p;
	}
	
	public int getW(){
		return w;
	}
}
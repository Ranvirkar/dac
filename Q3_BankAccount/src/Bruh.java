import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bruh {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		double sumofAllDeposite=0;
		double maxDeposite=0;
		double withdraw=0;
		double maxWithdraw=0;
		String dateMaxWithdraw="";
		
		try(BufferedReader br=new BufferedReader(new FileReader("BankStatement.txt"))){
			String str=br.readLine(); 
			
			
			while((str=br.readLine())!=null) {
				String []spliter =str.split(",");
				
				String tDate=spliter[0];
				String narration=spliter[1];
				double withdrawAmount=Double.parseDouble(spliter[2]);
				double depositeAmount=Double.parseDouble(spliter[3]);
				
				sumofAllDeposite+=depositeAmount;
				
				if(depositeAmount>maxDeposite) {
					maxDeposite=depositeAmount;
				}
				
				if("Shopping".equalsIgnoreCase(narration)) {
					withdraw+=withdrawAmount;
				}
				
				if(withdrawAmount>maxWithdraw) {
					maxWithdraw=withdrawAmount;
					dateMaxWithdraw=tDate;
				}
				
				
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(sumofAllDeposite);
		System.out.println(maxDeposite);
		System.out.println(withdraw);
		System.out.println(dateMaxWithdraw);

	}

}

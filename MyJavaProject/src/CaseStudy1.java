import java.util.Scanner;

public class CaseStudy1 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the mark of subject 1 : ");
		int mark1=sc.nextInt();
		System.out.println("Enter the mark of subject 2 : ");
		int mark2=sc.nextInt();
		System.out.println("Enter the mark of subject 3 : ");
		int mark3=sc.nextInt();
		
		double total=mark1+mark2+mark3;
		System.out.println("Total mark is : "+total);
		double percentage=(total/Integer.parseInt("150"))*Integer.parseInt("100");
		System.out.println("Percentage : "+percentage);
		
	}

}

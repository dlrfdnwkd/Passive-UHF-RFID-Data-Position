import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File dataFile = new File("RFID_Data.txt");
		Target target = new Target();
		Reference reference = new Reference();
		String[] targets = {"0x35E0170044CF0D590000F5A5","0x35E0170044CF0D590000F5A4","0x35E0170044CF0D590000F5A3",
				"0x35E0170044CF0D590000F5A2",
				"0x35E0170044CF0D590000F5B1",
				"0x35E0170044CF0D590000F5B0",
				"0x35E0170044CF0D590000F5AF",
				"0x35E0170044CF0D590000F5AE",
				"0x35E0170044CF0D590000F5BD" 
		};
		String readData;
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
			while((readData = br.readLine()) != null) {
				boolean targetExist = false;
				String datas[] = readData.split("=|,");
				for(String ID:targets) {
					if(ID.equals(datas[1])) {
						targetExist = true;
					}
				}
				if(targetExist==true) {
					Target sampleTarget = new Target();
					sampleTarget.setID(datas[1]);
					sampleTarget.setRssi(Integer.parseInt(datas[7]));
					sampleTarget.setIdentifiedTime(LocalDateTime.parse(datas[9]));
					target.insert(sampleTarget);
				}else {
					Reference sampleReference = new Reference();
					sampleReference.setID(datas[1]);
					sampleReference.setRssi(Integer.parseInt(datas[7]));
					sampleReference.setIdentifiedTime(LocalDateTime.parse(datas[9]));
					switch(datas[1]) {
					case "0x35E0170044CF0D590000F544":
						sampleReference.setX(7);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F543":
						sampleReference.setX(22);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F542":
						sampleReference.setX(37);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F551":
						sampleReference.setX(52);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F550":
						sampleReference.setX(67);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F54F":
						sampleReference.setX(81);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F61D":
						sampleReference.setX(101);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F61C":
						sampleReference.setX(116);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F61B":
						sampleReference.setX(131);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F61A":
						sampleReference.setX(146);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F629":
						sampleReference.setX(161);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F628":
						sampleReference.setX(176);
						sampleReference.setY(1);
						break;
					case "0x35E0170044CF0D590000F54E":
						sampleReference.setX(7);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F55D":
						sampleReference.setX(22);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F55C":
						sampleReference.setX(37);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F55B":
						sampleReference.setX(52);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F55A":
						sampleReference.setX(67);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F569":
						sampleReference.setX(81);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F627":
						sampleReference.setX(101);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F626":
						sampleReference.setX(116);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F635":
						sampleReference.setX(131);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F634":
						sampleReference.setX(146);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F633":
						sampleReference.setX(161);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F632":
						sampleReference.setX(176);
						sampleReference.setY(41);
						break;
					case "0x35E0170044CF0D590000F568":
						sampleReference.setX(7);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F567":
						sampleReference.setX(22);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F566":
						sampleReference.setX(37);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F575":
						sampleReference.setX(52);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F574":
						sampleReference.setX(67);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F573":
						sampleReference.setX(81);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F641":
						sampleReference.setX(101);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F640":
						sampleReference.setX(116);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F63F":
						sampleReference.setX(131);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F63E":
						sampleReference.setX(146);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F64D":
						sampleReference.setX(161);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F64C":
						sampleReference.setX(176);
						sampleReference.setY(80);
						break;
					case "0x35E0170044CF0D590000F572":
						sampleReference.setX(7);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F581":
						sampleReference.setX(22);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F580":
						sampleReference.setX(37);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F57F":
						sampleReference.setX(52);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F57E":
						sampleReference.setX(67);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F58D":
						sampleReference.setX(81);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F64B":
						sampleReference.setX(101);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F64A":
						sampleReference.setX(116);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F659":
						sampleReference.setX(131);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F658":
						sampleReference.setX(146);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F657":
						sampleReference.setX(161);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F656":
						sampleReference.setX(176);
						sampleReference.setY(115);
						break;
					case "0x35E0170044CF0D590000F58C":
						sampleReference.setX(7);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F58B":
						sampleReference.setX(22);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F58A":
						sampleReference.setX(37);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F599":
						sampleReference.setX(52);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F598":
						sampleReference.setX(67);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F597":
						sampleReference.setX(81);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F603":
						sampleReference.setX(101);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F5F8":
						sampleReference.setX(116);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F5F7":
						sampleReference.setX(131);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F5F6":
						sampleReference.setX(146);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F605":
						sampleReference.setX(161);
						sampleReference.setY(144);
						break;
					case "0x35E0170044CF0D590000F604":
						sampleReference.setX(176);
						sampleReference.setY(144);
						break;
					default :
						break;
					}
					reference.insert(sampleReference);
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		boolean stop = false;
		char select;
		do {
		System.out.println("=============================================================");
		System.out.println("   RFID Tag Information Analysis based Localization System   ");
		System.out.println("=============================================================");
		System.out.println(" A. Reference Tag Analysis");
		System.out.println(" B. Target Tag Analysis");
		System.out.println(" C. Estimation of Target Position(KNN)");
		System.out.println(" D. Estimation of Target Position(GNN)");
		System.out.println(" E. Quit");
		try {
			select = sc.next().toUpperCase().charAt(0);
			switch(select){
				case 'A':
					reference.view();
					break;
				case 'B':
					target.view();
					break;
				case 'C':
					System.out.println("KNN알고리즘 : k를 입력하세요.");
					int k = sc.nextInt();
					target.positionKNN(reference, k);
					break;
				case 'D':
					System.out.println("GNN알고리즘 : g를 입력하세요.");
					int g = sc.nextInt();
					target.positionGNN(reference, g);
					break;
				case 'E':
					stop = true;
					System.out.println("프로그램이 종료됩니다.");
					break;
				default :
					System.out.println("잘못입력했습니다. 다시 입력해 주세요.");
			}
		}catch(InputMismatchException e) {
			System.out.println("잘못입력했습니다.다시 실행시켜 주세요.");
		}
		}while(stop==false);
		sc.close();
	}

}

package com.project;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
//This done by the use of Stack
//Chat bot program with tamil and english language 
public class ChatBot {

	static Stack<YourOption> storeStack = new Stack<YourOption>();
	static int languageChoice;

	public static void main(String args[]) {
		ChatBot obj = new ChatBot();
		obj.menu();
		System.out.println();


	}

	public void menu() {
		int choice;
		storeStack.push(new YourOption(0, 0));
		print(0, 0);
		do {
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter your option : ");
			choice = input.nextInt();
			
			if (choice == 9) {
				storeStack.pop();

				if (storeStack.isEmpty()) {
					break;
				}
			} else {
				storeStack.push(new YourOption(storeStack.peek().level + 1, choice));

			}
			YourOption top = storeStack.peek();
			print(top.level, top.choice);

		} while (choice != 0);
		System.out.println("Thank you for visiting our website...");
	}

	private static void print(int level, int choice) {

		for (String choiceString : getChoices(level, choice)) {
			System.out.println(choiceString);
		}
	}

	static ArrayList<String> getChoices(int level, int choice) {
		ArrayList<String> choiceList = new ArrayList();
		if (level == 0) {
			choiceList.add(MainMenu.OPTION_1.toString());
			choiceList.add(MainMenu.OPTION_2.toString());
			choiceList.add(MainMenu.OPTION_3.toString());
			
		} else if (level == 1) {
			languageChoice=choice;
			switch (choice) {
			case 1:
				choiceList.add(English.OPTION_1.toString());
				choiceList.add(English.OPTION_2.toString());
				choiceList.add(English.OPTION_3.toString());
				choiceList.add(English.OPTION_4.toString());
				choiceList.add(English.OPTION_5.toString());
				choiceList.add(English.OPTION_6.toString());
				break;
			case 2:
				choiceList.add(Tamil.OPTION_1.toString());
				choiceList.add(Tamil.OPTION_2.toString());
				choiceList.add(Tamil.OPTION_3.toString());
				choiceList.add(Tamil.OPTION_4.toString());
				choiceList.add(Tamil.OPTION_5.toString());
				choiceList.add(Tamil.OPTION_6.toString());
				break;
			}
		} else if (level == 2) {
			if(languageChoice==1) {
			switch (choice) {
			
			case 1:
				choiceList.add(Recharge.OPTION_1.toString());
				choiceList.add(Recharge.OPTION_2.toString());
				choiceList.add(Recharge.OPTION_3.toString());
				choiceList.add(Recharge.OPTION_4.toString());
				break;
			case 2:
				choiceList.add(CallerTune.OPTION_1.toString());
				choiceList.add(CallerTune.OPTION_2.toString());
				choiceList.add(CallerTune.OPTION_3.toString());
				choiceList.add(CallerTune.OPTION_4.toString());
				choiceList.add(CallerTune.OPTION_5.toString());
				choiceList.add(CallerTune.OPTION_6.toString());
				break;
			case 3:
				choiceList.add(Dth.OPTION_1.toString());
				choiceList.add(Dth.OPTION_2.toString());
				choiceList.add(Dth.OPTION_3.toString());
				choiceList.add(Dth.OPTION_4.toString());
				choiceList.add(Dth.OPTION_5.toString());
				break;
			case 4:
				choiceList.add(NewOffers.OPTION_1.toString());
				choiceList.add(NewOffers.OPTION_2.toString());
				choiceList.add(NewOffers.OPTION_3.toString());
				choiceList.add(NewOffers.OPTION_4.toString());
				choiceList.add(NewOffers.OPTION_5.toString());
				choiceList.add(NewOffers.OPTION_6.toString());
				break;
			}}if(languageChoice==2) {
				switch (choice) {
				
				case 1:
					choiceList.add(TamilRecharge.OPTION_1.toString());
					choiceList.add(TamilRecharge.OPTION_2.toString());
					choiceList.add(TamilRecharge.OPTION_3.toString());
					choiceList.add(TamilRecharge.OPTION_4.toString());
					break;
				case 2:
					choiceList.add(TamilCallerTune.OPTION_1.toString());
					choiceList.add(TamilCallerTune.OPTION_2.toString());
					choiceList.add(TamilCallerTune.OPTION_3.toString());
					choiceList.add(TamilCallerTune.OPTION_4.toString());
					choiceList.add(TamilCallerTune.OPTION_5.toString());
					choiceList.add(TamilCallerTune.OPTION_6.toString());
					break;
				case 3:
					choiceList.add(TamilDth.OPTION_1.toString());
					choiceList.add(TamilDth.OPTION_2.toString());
					choiceList.add(TamilDth.OPTION_3.toString());
					choiceList.add(TamilDth.OPTION_4.toString());
					choiceList.add(TamilDth.OPTION_5.toString());
					break;
				case 4:
					choiceList.add(TamilNewOffers.OPTION_1.toString());
					choiceList.add(TamilNewOffers.OPTION_2.toString());
					choiceList.add(TamilNewOffers.OPTION_3.toString());
					choiceList.add(TamilNewOffers.OPTION_4.toString());
					choiceList.add(TamilNewOffers.OPTION_5.toString());
					choiceList.add(TamilNewOffers.OPTION_6.toString());
					break;
				}}
			
		} else if (level == 3) {
			if(languageChoice==1) {
			System.out.println("Your plan executed Sucessfully");
			System.out.println("9-Back");
			System.out.println("0-Exit");}
	
		if(languageChoice==2) {
			System.out.println("உங்கள் திட்டம் வெற்றிகரமாக செயல்படுத்தப்பட்டது");
			System.out.println("9-முந்தையா நிலைக்கு செல்ல");
			System.out.println("0-வெளியேர");}
		}

		return choiceList;
	}

	static class YourOption {
		private int level;
		private int choice;

		YourOption(int level, int choice) {
			this.level = level;
			this.choice = choice;
		}

		public int getLevel() {
			return level;
		}

		public int getChoice() {
			return choice;
		}


		public void setLevel(int level) {
			this.level = level;
		}

		public void setChoice(int choice) {
			this.choice = choice;
		}

	}

	public enum MainMenu {
		OPTION_1("1.English"), OPTION_2("2.தமிழ்"), OPTION_3("0-Exit");

		private final String text;

		MainMenu(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	public enum English {
		OPTION_1("1.Rechare"), OPTION_2("2.Caller_Tune"), OPTION_3("3.DTH"), OPTION_4("4.New Offers"),
		OPTION_5("9-Back"), OPTION_6("0.Exit");

		private final String text;

		English(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	public enum Tamil {
		OPTION_1("1.ரீஜார்ச்"), OPTION_2("2.காலர் டியுன்"), OPTION_3("3.டிடிஎச்"), OPTION_4("4.புதிய ஆஃபர்"),OPTION_5("9-முந்தையா நிலைக்கு செல்ல"), OPTION_6("0.வெளியேர");;

		private final String text;

		Tamil(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	public enum Recharge {
		OPTION_1("1.Rechare through Airtel Payments Bank Account"), OPTION_2("2.Coupon Recharge"), OPTION_3("9.Back"),
		OPTION_4("0.Exit");

		private final String text;

		Recharge(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}
	
	public enum TamilRecharge {
		OPTION_1("1.ஏர்டெல் பேமெண்ட்ஸ் வங்கி கணக்கு மூலம் ரீசார்ஜ் செய்ய"), OPTION_2("2.கூப்பன் ரீசார்ஜ்"), OPTION_3("9.முந்தையா நிலைக்கு செல்ல"),
		OPTION_4("0.வெளியேர");

		private final String text;

		TamilRecharge(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	public enum CallerTune {
		OPTION_1("1.Arabic Kuthu"), OPTION_2("2.Mudhal Nee Mudivu Nee"), OPTION_3("3.Naanga Vera Maari"),
		OPTION_4("4.Two Two Two"), OPTION_5("9.Back"), OPTION_6("0-Exit");

		private final String text;

		CallerTune(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}
	public enum TamilCallerTune {
		OPTION_1("1.அரபி குத்து"), OPTION_2("2.முதல் நீ முடிவும் நீ"), OPTION_3("3.நாங்க வேற மாறி"),
		OPTION_4("4. டூ டூ டூ "), OPTION_5("9.முந்தையா நிலைக்கு செல்ல"), OPTION_6("0-வெளியேர");

		private final String text;

		TamilCallerTune(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	public enum Dth {
		OPTION_1("1.Airtel DTH HD Plan Rs.251=49Channels+30D"), OPTION_2("2.Airtel DTH ₹ 285 Pack = 68 Channels+30D"),
		OPTION_3("3.Airtel DTH ₹ 252 Pack = 78 Channels+30D"), OPTION_4("9.Back"), OPTION_5("9.Exit");

		private final String text;

		Dth(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}
	public enum TamilDth {
		OPTION_1("1.ஏர்டெல் டிடிஎச் எச்டி திட்டம் Rs.251=49சேனல்கள்+30D"), OPTION_2("2.ஏர்டெல் டிடிஎச் ₹ 285 திட்டம் = 68 சேனல்கள்+30D"),
		OPTION_3("3.ஏர்டெல் டிடிஎச் ₹ 252 Pack = 78 சேனல்கள்+30D"), OPTION_4("9.முந்தையா நிலைக்கு செல்ல"), OPTION_5("9.வெளியேர");

		private final String text;

		TamilDth(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	public enum NewOffers {
		OPTION_1("1.265=UL call+1GB/D,28D"), OPTION_2("2.479=UL call+1.5GB/D,56D"),
		OPTION_3("3.299=UL call+1.5GB/D28D"), OPTION_4("4.549=UL call+25GB/D,56D"), OPTION_5("9.Back"),
		OPTION_6("0.Exit");

		private final String text;

		NewOffers(final String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}
	public enum TamilNewOffers {
		OPTION_1("1.265=UL அழைப்பு+1GB/D,28D"), OPTION_2("2.479=UL அழைப்பு+1.5GB/D,56D"),
		OPTION_3("3.299=UL அழைப்பு+1.5GB/D28D"), OPTION_4("4.549=UL அழைப்பு+25GB/D,56D"), OPTION_5("9.முந்தையா நிலைக்கு செல்ல"),
		OPTION_6("0.வெளியேர");

		private final String text;

		TamilNewOffers(final String text) {
			this.text = text;
		}
		public String toString() {
			return text;
		}
	}
}

import java.util.ArrayList;
public class Parser{
	public static void main(String[] args){
		String exString = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Doug here is your next fare:</h3>\n<p>\nRide #1544510358<br/>\n<b>Rider: Al Madrigal</b><br/>\n3 people<br/>\nGoing FROM Fresno to Sacramento<br/>\nFare is $67.49<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href=\"distance.cgi?rideNumber=1544510358\">https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=1544510358</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href=\"rating.cgi?rideNumber=1544510358\"/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=1544510358</a><br/>\nThen we'll let you know how Al Madrigal rated you.\n</p>\n";
		//String exString = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Prateek here is your next fare:</h3>\n<p>\nRide #15225102A6[UberJavaX Premium]<br/>\n<b>Rider: Pierre Salinger</b><br/>\n2 people<br/>\nGoing FROM San Francisco to Sacramento<br/>\nSURGE PRICING IN EFFECT: Fare is $53.10<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href='distance.cgi?rideNumber=15225102A6'>https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=15225102A6</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href='rating.cgi?rideNumber=15225102A6'/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=15225102A6</a><br/>\nThen we'll let you know how Pierre Salinger rated you.\n</p>\n";
		//String exString = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Lauren here is your next fare:</h3>\n<p>\nRide #15015133B2[UberJavaX Premium]<br/>\n<b>Rider: Bill Russell</b><br/>\n3 people<br/>\nGoing FROM Redding to San Jose<br/>\nDOUBLE SURGE PRICING IN EFFECT: Fare is $196.49<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href='distance.cgi?rideNumber=15015133B2'>https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=15015133B2</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href='rating.cgi?rideNumber=15015133B2'/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=15015133B2</a><br/>\nThen we'll let you know how Bill Russell rated you.\n</p>";
		String delim = "\n+";
		String [] eachLine = exString.split(delim);
		//ArrayList<String> myStuff = new ArrayList<>();
	// RIDE NO.
	for (String i: eachLine){
			if(i.contains("Ride")){
				String s = i;
				s=s.substring(s.indexOf(" ") + 1);
				s=s.substring(0, s.indexOf("<"));
				String rideNumber = s;
				System.out.println("Ride Number " + rideNumber);
				break;
			}
		}
	// NAME OF RIDER
	for (String i: eachLine){
			if(i.contains("Rider")){
				String s = i;
				s=s.substring(s.indexOf(" ") + 1);
				s=s.substring(0, s.indexOf("<"));
				String rider = s;
				System.out.println("Name of rider: " + rider);
				break;
			}
		}
	// FARE
	for (String i: eachLine){
			if(i.contains("Fare")){
				String s = i;
				s=s.substring(s.indexOf("$") + 1);
				s=s.substring(0, s.indexOf("<"));
				double fare = Double.parseDouble(s);
				System.out.println("Fare: "+ s);
				break;
			}
		}
	// NO. OF PEOPLE
	for (String i: eachLine){
			if(i.contains("people")){
				String s = i;
				s=s.substring(0, s.indexOf(" "));
				int people = Integer.parseInt(s);
				System.out.println("People: "+ s);
				break;
			}
		}
	// STARTIG POINT AND ENDING POINT
	for (String i: eachLine){
			if(i.contains("FROM")){
				String s = i;
				s=s.substring(s.indexOf("M") + 2);
				s=s.substring(0, s.indexOf("t")-1);
				String from = s;
				System.out.println("Staring at: "+ from);
				String t = i;
				t=t.substring(t.indexOf("to") + 3);
				t=t.substring(0, t.indexOf("<"));
				String to = t;
				System.out.println("Going to: "+ to);
				break;
			}
		}
	// SURGING
	for (String i: eachLine){
			if (i.contains("SURGE")){
				if (i.contains("DOUBLE SURGE")){
					boolean isSurgePricing = false;
					boolean isDoubleSurgePricing =  true;
					System.out.println("Price Surging: "+ isSurgePricing);
					System.out.println("Double Price Surging: "+ isDoubleSurgePricing);
					break;
				}else if (!i.contains("DOUBLE SURGE") && i.contains("SURGE")){
					boolean isSurgePricing = true;
					boolean isDoubleSurgePricing =  false;
					System.out.println("Price Surging: "+ isSurgePricing);
					System.out.println("Double Price Surging: "+ isDoubleSurgePricing);
					break;
				}
				else if (!i.contains("DOUBLE SURGE") && !i.contains("SURGE")) {
					boolean isSurgePricing = false;
					boolean isDoubleSurgePricing = false;
					System.out.println("Price Surging: "+ isSurgePricing);
					System.out.println("Double Price Surging: "+ isDoubleSurgePricing);
					break;
				}
			}
		}
	// UBERX
	for (String i: eachLine){
		if (i.contains("[UberJavaX Premium]")){
			boolean isUberJavaXPremium = true;
			System.out.println("Premium Uber: "+ isUberJavaXPremium);
		}
	}
	//System.out.println(myStuff);
}

}
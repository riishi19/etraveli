package com.weather.alert.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weather.alert.entities.LocWeather;
import com.weather.alert.entities.Location;
import com.weather.alert.service.NotificationService;
import com.weather.user.entities.User;
import com.weather.user.entities.UserPreference;
import com.weather.user.service.UserService;

@Controller
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	

	@RequestMapping("/alert")
	public ModelAndView getNotification() {

		List<LocWeather> locList = notificationService.findAll();

		List<User> userlist = userService.findAll();

		List<UserPreference> notificationList = new ArrayList<>();

		//Try to use flat map here
		
		/*
		 * 
		//creating ArrayList      
List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");  
List<String>  productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");  
List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");  
List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");  
List<List<String>> allproducts = new ArrayList<List<String>>();   
//adding elements to the list  
allproducts.add(productlist1);  
allproducts.add(productlist2);  
allproducts.add(productlist3);  
allproducts.add(productlist4);  
//creating a list of all products  
List<String> listOfAllProducts = new ArrayList<String>();  
//for each loop iterates over the list  
for(List<String> pro : allproducts)   
{  
for(String product : pro)   
{  
//adds all products to the list      
listOfAllProducts.add(product);  
}  
}  
System.out.println("List Before Applying mapping and Flattening: \n");  
//prints stream before applying the flatMap() method  
System.out.println(listOfAllProducts);  
System.out.println();  
//creats a stream of elemnts using flatMap()  
List<String> flatMapList = allproducts .stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());   
System.out.println("List After Applying Mapping and Flattening Operation: \n");   
//prints the new stream that we get after applying mapping and flattening   
System.out.println(flatMapList);          
}  



// Driver code
    public static void main(String[] args)
    {   
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
          
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
          
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
  
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
  
        System.out.println("The Structure before flattening is : " +
                                                  listOfListofInts);
          
        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                                    .flatMap(list -> list.stream())
                                    .collect(Collectors.toList());
  
        System.out.println("The Structure after flattening is : " +
                                                         listofInts);
    }
		
		
		private static <T> Set<T> findCommonElements(List<T> first, List<T> second) {
        return first.stream().filter(second::contains).collect(Collectors.toSet());
    }
 
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 3, 1, 6, 5, 7, 3);
        List<Integer> second = Arrays.asList(2, 3, 4, 5, 3);
 
        Set<Integer> common = findCommonElements(first, second);
        System.out.println(common);
    }
    
    
    
    
    //Example : Counting number of students.
		Long studentCount = studentList.stream().collect(Collectors.counting());
        
		System.out.println(studentCount);
		
		//Example : Collecting highest percentage.
		
		Optional<Double> highPercentage = studentList.stream().map(Student::getPercentage).collect(Collectors.maxBy(Comparator.naturalOrder()));
        
		System.out.println(highPercentage);
		
		//Example : Collecting lowest percentage.
		Optional<Double> lowPercentage = studentList.stream().map(Student::getPercentage).collect(Collectors.minBy(Comparator.naturalOrder()));
        
		System.out.println(lowPercentage);
		
		//Example : Collecting sum of percentages
		Double sumOfPercentages = studentList.stream().collect(Collectors.summingDouble(Student::getPercentage));
        
		System.out.println(sumOfPercentages);
		
		//Example : Collecting average percentage
		Double averagePercentage = studentList.stream().collect(Collectors.averagingDouble(Student::getPercentage));
		
		
		//Example : Grouping the students by subject
		Map<String, List<Student>> studentsGroupedBySubject = studentList.stream().collect(Collectors.groupingBy(Student::getSubject));
        
		System.out.println(studentsGroupedBySubject);
		
		//Example : Partitioning the students who got above 80.0% from who don’t.
		Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream().collect(Collectors.partitioningBy(student -> student.getPercentage() > 80.0));
        
		System.out.println(studentspartionedByPercentage);
		
		 */
		
		for (User user : userlist) {
			for (LocWeather locWeather : locList) {
				//Double averagePercentage = locWeather.stream().collect(Collectors.averagingDouble(locWeather.getMax_temp()::getPercentage));
				for (Location location : locWeather.getLocation()) {
					
					if (user.getLocation().getLocationid() == location.getLocationid()) {
						//Get Average first
						
						notificationService.getNotificationList(notificationList, user, locWeather);
					}
				}
			}
		}
		if (null != notificationList && notificationList.size() >= 1) {
			notificationService.sendAlert(notificationList);

		}
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("home", notificationList);
		return mav;
	}


	/*
	 * A cron expression to execute at every thirty minutes
	 *
	 */
	@Scheduled(cron = "* */30 * * * *")
	public void Scheduled() {
		System.out.println("Scheduler execute at every thirty minutes");
		getNotification();
	}

}

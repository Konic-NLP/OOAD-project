# OOAD-project4
**A course project repo for CSCI5448**. <br>
**Group member**: Sijia Ge, Xiaosong Wang, and Zhiyong Wang.<br>
Java Version:16.0.2 <br>
Code Version:3.0 <br>

The **output files** are in the [output](https://github.com/Konic-NLP/OOAD-project/tree/Project4/output) folder. including `output.txt` for console output, chart_1.jpg/chart_2 jpg for the graph output via `xchart` libray, and daily logger produced by the `Logger` class <br>

The 15 **tests cases** are in the [testCasewithJunit](https://github.com/Konic-NLP/OOAD-project/tree/Project4/testCasewithJunit) folder. <br>

The link to Project2 Part1 version of UML:
[UML 1.0](https://drive.google.com/file/d/1DqevxZm52xK2XGYTwmdSzqwT_yVpVpwH/view?usp=sharing)
<br>

The link to Project2 Part2 version of UML:
[UML 1.1](https://drive.google.com/file/d/1VHzqbyiT67pNIZOGk6VxLyTKSjVw6SfF/view?usp=sharing)
<br>

The link to Project3 Part1 version of UML:
[UML 2.0](https://drive.google.com/file/d/1hSDn2l9CgKIbKhYhrpg_vuS4Z9ieeJdF/view?usp=sharing)
<br>

The link to Project3 Part2 (current) version of UML:
[UML 2.1](https://drive.google.com/file/d/1m1sBKMnuXuZXXbP9N78wuhJgt7NsPCx_/view?usp=sharing)
<br>

The link to Project4 Part2 (current) version of UML:
[UML 3.0](https://drive.google.com/file/d/12sm19SfrJttH4s0VWrt7HOuehYth0sI-/view?usp=sharing)
<br>

The link to the document that describes the changes from 1.0 to 1.1 of our UML: 
[UML Documentation1](https://docs.google.com/document/d/1-oRimywqX2OO93JRNCVeBiB7w9DjRaM1/edit?usp=sharing&ouid=107958256533487600087&rtpof=true&sd=true) <br>

The link to the document that describes the changes from 1.1 to 2.0 of our UML: 
[UML Documentation2](https://docs.google.com/document/d/1BesRkDBqgKqdcQbCI5BAd9jSxvViktC3CdPi2sptryk/edit?usp=sharing) <br>

The link to the document that describes the changes from 2.0 to 2.1 of our UML: 
[UML Documentation3](https://docs.google.com/document/d/1SlzilDsgJlP43i0qHNBBo2lF20u1aGkEvNOy1AfkgkM/edit?usp=sharing)<br>

*note: we ddin't make any modifications on the UML 3.0 version while we draw the UML for the pattern which was implemented in the Project 4 specifically as below*  


## Regarding the Design Patterns
1. Strategy  <br>
We create an interface tuneAlgorithm that contains three subclasses of specific tune algorithms. The three objects of the Staff class will delegate these three subclasses: each Staff object will have a specific tune algorithm. <br>

2. Observer  <br>
We create a class concreteSubject to implement interface Subject, which receives messages/information from Staff and sends messages to Logger and Tracker. The Logger and Tracker take the responsibility to reprocess the messages sent to them. <br>

3. Decorator <br>
We create an abstract class addDecorator extending the abstract class inventory. Four concrete decorators will inherit from the addDecorator and wrap the inventory object. <br>

4. Command pattern <br>
We apply the Command pattern to interact with a user via command line. Invoker holds two collections of commands for each store and interact with the user via `Scanner` class.  
First the user could choose a store to manipulate and a local variable will refer to the specific commandlist according to the choice of the user, then the user could type the    
option to the invoker, and invoker will invoke the `execute()` method of the ith(i equals the option number) command in the commandlist gotten from the first interaction, and  
each command hold a `Store` object as the receiver, and then call the corresponding method to perform the function.  
[Graph](https://drive.google.com/file/d/12sm19SfrJttH4s0VWrt7HOuehYth0sI-/view?usp=sharing)


5. Abstract Factory pattern <br>
We apply the abstract factory to generate Guitarkit. <br>
The Store is the client for this pattern. The North Store is associated with the North Factory, while the South Store is associated with the South Factory.<br>
For each kinds of elements, there are three subtypes:type A, B, and C. <br>
The two factories are different in terms price: for the same type of element, the south store's price is always twice as the north store's price. <br> 
The factory will choose different types of elements to make up Guitarkit according to the parameters it receives.<br>
[Graph](https://drive.google.com/file/d/12Ue7KuNTLZ4JPREAdEdONFB4NPhDoO85/view?usp=sharing)

6. Singleton pattern <br>
we apply the singleton pattern for logger and tracker class, making both of them only have one object. <br>
Moreover, we will use lazy instantiation for logger and eager instantiation for tracker.<br>
[Graph](https://drive.google.com/file/d/173fz9efP1HEeUEfT45CkFsxtQu3Q3b9z/view?usp=sharing) <br>

## To make the code run, we adopt the bellowing modifications/Assumptions:
<li> The conditions of items are integers from 1 to 5 inclusively. The correspond relation between number and words is {Poor:1, Fair:2, Good:3, Very Good:4, Excellent:5}.</li>
<li> The price of items is an integer. When the price is changed 1.1 times, 0.9 times, the 0.8 times, the (int) method is applied to truncate the float into int .</li>
<li> If the order is delivered on Sunday, when the store is closed, the staff of Monday will put items of the order in the inventory on that day.</li>
<li> If the day is sunday, both clerk's consecutive work days will clean to zero</li>
<li> the correspondent situation wth different prices: 
  <ol> 
    <li>listprice:when the buyer first time to consult with the price;</li>
    <li>saleprice:when the buyer second time to consult with the price;</li>
    <li>purchaseprice: the price for ordered new items;</li>
    </ol>

<li> Once any kind of clothing are sold out, the rest subtypes of clothing would also be removed from the inventory. </li>
<li> If the customer wants to buy stringed instruments, even if some kind of additional items the customer may also want to buy are out of stock, it will not impact this whole transaction. e.g, if there is no gigbag in the store but Strings, the customer will buy Stringed instruments + Strings.</li>
<li> We generate Poisson distribution with commons.math3 jar package.</li>
<li> On each day, the three staffs have even chance to be sick, no matter they are no duty or not, and ones who are not on duty that day for that day will reset his/her consecutive work days.</li> 

<li>In commend line, input from users should be appropriate such as integer. However, we haven't handle the outlier input problem due to time limitation.</li>
<li>When commend users willing to purchase an item from the store, it requires an input of item's name from scanner. When commend user willing to sell an item to the store, the item will be generated by the program and there is no need to type in the item's name.</li>
<li>When commend users willing to buy the guitar kit, the transaction will be completed directly without offering discount from store.</li>
<li>When commend users asking for current time, our program acquire the system time and print it out.</li>
<li>All information was saved in one hashmap in Tracker. Logger will generate two separate files for both store each day.</li>
<li>In our Abstract Factory pattern, customer will randomly choose the choices of each category of guitar kit part.</li>
<li>We create two line charts by importing charting library XChart.</li>
<li>The item sales, total register, counts of items in inventory, damaged items, and item sold which are shown in line charts are the sum of two stores.</li>
<li>We assume that only one clerk in the object pool will be sick each day.</li>
<li>We assume that the raw elements of the guitar kit of the south store are all hand-made, so the price of the element at the south store is twice the price of the same element at the north store.</li>
<li>The number damage items refer to the number that the Clerk damage the items and reduce the condition of the item, number of destroyed items refer to the amount that damaged and then reduce the condition to 0 and removed from the inventory.</li>

<li> the sale of guitar kit does not count into the count record in the logger but does in anywhere else.</li>
<li> The external package we are currently using in the project:  </li>
  1. Junit 3.8.2  
  2. commons-math 3.6.1  
  3. xchart 3.8.1


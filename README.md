# OOAD-project3
**A course project repo for CSCI5448**. <br>
**Group member**: Sijia Ge, Xiaosong Wang, and Zhiyong Wang.<br>
Java Version:16.0.2 <br>
Code Version:2.0 <br>


The link to Project2 Part1 version of UML:
[UML 1.0](https://drive.google.com/file/d/1DqevxZm52xK2XGYTwmdSzqwT_yVpVpwH/view?usp=sharing)
<br>

The link to Project2 Part2 version of UML:
[UML 1.1](https://drive.google.com/file/d/1VHzqbyiT67pNIZOGk6VxLyTKSjVw6SfF/view?usp=sharing)
<br>

The link to Project3 Part1 version of UML:
[UML 2.0](https://drive.google.com/file/d/1m1sBKMnuXuZXXbP9N78wuhJgt7NsPCx_/view?usp=sharing)
<br>

The link to Prpject3 Part2 (current) version of UML:
[UML 2.1](https://drive.google.com/file/d/1m1sBKMnuXuZXXbP9N78wuhJgt7NsPCx_/view?usp=sharing)
<br>

The link to the document that describes the changes from 1.0 to 1.1 of our UML: 
[UML Documentation1](https://docs.google.com/document/d/1-oRimywqX2OO93JRNCVeBiB7w9DjRaM1/edit?usp=sharing&ouid=107958256533487600087&rtpof=true&sd=true) <br>

The link to the document that describes the changes from 1.1 to 2.0 of our UML: 
[UML Documentation2](https://docs.google.com/document/d/1BesRkDBqgKqdcQbCI5BAd9jSxvViktC3CdPi2sptryk/edit?usp=sharing) <br>

The link to the document that describes the changes from 1.1 to 2.0 of our UML: 
[UML Documentation3](https://docs.google.com/document/d/1SlzilDsgJlP43i0qHNBBo2lF20u1aGkEvNOy1AfkgkM/edit?usp=sharing) <br>

## Regarding the three Design Patterns
1.Stragety  <br>
We create an interface tuneAlgorithm that contains three subclasses of specific tune algorithms. The three objects of the Staff class will delegate these three subclasses: each Staff object will have a specific tune algorithm. <br>

2.Observer  <br>
We create a class concreteSubjct to implement interface Subject, which receives messages/information from Staff and sends messages to Logger and Tracker. The Logger and Tracker take the responsibility to reprocess the messages sent to them. <br>

3.Decorator <br>
We create an abstract class addDecorator extending the abstract class inventory. Four concrete decorators will inherit from the addDecorator and wrap the inventory object. <br>

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

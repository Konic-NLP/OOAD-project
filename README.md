# OOAD-project
**A course project repo for CSCI5448**. <br>
**Group member**: Sijia Ge, Xiaosong Wang, and Zhiyong Wang.<br>
Java Version:16.0.2 <br>
Code Version:1.0 <br>

The output result of our code is in output.txt. <br>

The link to Part1 (former) version of UML:
[UML 0.0](https://drive.google.com/file/d/1DqevxZm52xK2XGYTwmdSzqwT_yVpVpwH/view?usp=sharing)
<br>

The link to Part2 (current) version of UML:
[UML 1.0](https://drive.google.com/file/d/1VHzqbyiT67pNIZOGk6VxLyTKSjVw6SfF/view?usp=sharing)
<br>

The link to the document that describes the changes of our UML: 
[UML Documentation](https://docs.google.com/document/d/1-oRimywqX2OO93JRNCVeBiB7w9DjRaM1/edit?usp=sharing&ouid=107958256533487600087&rtpof=true&sd=true) <br>

To make the code run, we adopt the bellowing modifications/Assumptions:<br>
<ol>
<li> The conditions of items are integers from 1 to 5 inclusively. The correspond relation between number and words is {Poor:1, Fair:2, Good:3, Very Good:4, Excellent:5}.</li>
<li> The price of items is an integer. When the price is changed 1.1 times, 0.9 times, the 0.8 times, the (int) method is applied to truncate the float into int .</li>
<li> If the order is delivered on Sunday, when the store is closed, the staff of Monday will put items of the order in the inventory on that day.</li>
<li> if today is sunday, both clerk's consecutive work days will clean to zero</li>
<li> the correspondent situation wth different prices: 
  <ol>
    <li>listprice:when the buyer first time to consult with the price;</li>
    <li>saleprice:when the buyer second time to consult with the price;</li>
    <li>purchaseprice: the price for ordered new items;</li>
    </ol>
</ol>
As for the OO term examples: <br>
1. Examples of Inheritance can be found in Items.java, where each subclass inherits from the Parent class.
2. Examples of Polymorphism can be found in Items.java, where subclass's Constructor and getter method overrides the Parent Class. Examples of Polymorphism can also be found in the Staff.java
3. Examples of Cohesion can be found in Helper,java, where each method only has one basic thing/function to do.
4. One example of Identity can be found in Staff.java, where the checkWithBuyer method check the content of two objects instead of the identity of two objects.
5. Examples of Encapsulation can be found in Items.java, where classes' attributes are private and protected.
6. One Example of Abstraction can be found in Staff.java, where the cehckRegister delegates with other methods, without concerning the details.

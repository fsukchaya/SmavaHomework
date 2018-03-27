# SmavaHomework
## Additional setup
- create configuration file for TestNG (tests.xml)
  * set parameters in tests.xml
  
    ```
    <parameter name="aURL" value="https://www.smava.de"/>
    <parameter name="aBrowser" value="chrome"/>
    ```
  
  * use xml file for running TestNG suite

    ```
    <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-surefire-plugin</artifactId
           <version>2.21.0</version>
               <configuration>
                   <suiteXmlFiles>
                       <suiteXmlFile>tests.xml</suiteXmlFile>
                   </suiteXmlFiles>
               </configuration>
    </plugin>
    ```
    
    

# termProject


The main purpose of this project is to design a nationwide disease release and early warning platform.  There are 4 enterprises (Population, hospital, CDC, government), 8 organizations, and 10 roles. MySQL database is used in this project.

**The platform workflow**
The personal data of the masses is recorded in the population enterprise. When the masses get sick and register at the hospital, the hospital enterprise will record the patient's vital signs. The doctor will give a diagnosis based on the patient's vital signs, and the pharmacy will prescribe medicine according to the doctor's diagnosis. The hospital's CDC report department will collect and count various diseases diagnosed in the hospital and report to the CDC department of the country. The CDC organization is responsible for collecting and summarizing disease diagnosis information reported by hospitals across the country, and reporting the summary results to the government organization. The government organization will issue or revoke related disease alerts nationwide based on real-time results, and the public will receive emails related to the alerts.

**background**

Hospital: 
There are four organzitions, including administration department, doctor department, pharmacy department, and CDC report department.
Adminstrations department can review and check all registrations by patients.
Doctor department can check patients vital signs and give diagnosis.
Pharmacy department will prescribe according to the doctor's diagnosis.
CDC report department who can report the suspicious cases to CDC and they can see the status of each report. 

CDC: can accept or ignore the report from hospitals, see the list of reported cases including detailed informations like disease, diagnosis, treatment and userid. Then CDC admin can choose to report the issue to government, generate a warning based on existed cases. In this step, the admin will receive an email.





Class Diagram


![image](https://user-images.githubusercontent.com/113845857/207117392-99676bfc-dc38-4931-b564-1184d9ff7973.png)




![image](https://user-images.githubusercontent.com/113845857/207117763-4bdba929-2f06-4603-81ac-e4bf686a50c1.png)


![Untitled Diagram drawio](https://user-images.githubusercontent.com/97858633/207393089-c5c721d5-9f2a-4ec6-ba91-c2117ccbe8ba.png)
![Untitled Diagram drawio-2](https://user-images.githubusercontent.com/97858633/207396093-57f9eb15-ddb7-44f9-bfdc-5263c1d61931.png)

**Note:**Below Rest APIs are developed with Java, Spring Boot and H2 in memory database

**Develop following REST endpoints to fetch data with filters.**                        

**1. Get a list of employees with filters for:**                    
- Performance score for a given review_date
- Department (should support multiple departments contains filter)
- Projects (should support multiple projects contains filter)                                        
**API URL:**                                                                                     
**localhost:8080/api/filter?reviewDate=2023-06-01&departments=Marketing&departments=HR&projects=Apollo&projects=Nova**                
**Success Response:**                                                                                                        
[
    {
        "id": 5,
        "name": "Madhav",
        "email": "madhav@example.com",
        "departmentId": 3,
        "dateOfJoining": "2023-01-24T18:30:00.000+00:00",
        "salary": 60000.0,
        "managerId": 1
    }

]

![image](https://github.com/user-attachments/assets/1174d2aa-512d-4c1c-afab-19336caf0db0)


**2. Fetch detailed employee information, including department, projects, and last 3
performance reviews using id.**                                                                        
**API URL:**                                                                                         
**localhost:8080/api/details?id=2**                                                                                    
**Sucess Response:**                                                                                                        

{
    "employee": {
        "id": 2,
        "name": "Ram",
        "email": "ram@example.com",
        "departmentId": 1,
        "dateOfJoining": "2021-03-19T18:30:00.000+00:00",
        "salary": 75000.0,
        "managerId": 1
    },
    "department": {
        "id": 1,
        "name": "Engineering",
        "budget": 500000.0
    },
    "projects": [
        {
            "id": 101,
            "name": "Apollo",
            "startDate": "2023-12-31T18:30:00.000+00:00",
            "endDate": "2025-01-30T18:30:00.000+00:00",
            "departmentId": 1
        }
    ],
    "recentReviews": [
        {
            "id": 1002,
            "employeeId": 2,
            "reviewDate": "2023-05-31T18:30:00.000+00:00",
            "score": 7,
            "reviewComments": "Good"
        },
        {
            "id": 1008,
            "employeeId": 2,
            "reviewDate": "2022-11-30T18:30:00.000+00:00",
            "score": 8,
            "reviewComments": "Very Good"
        }
    ]
}
![image](https://github.com/user-attachments/assets/4a596c0f-30f5-4d8c-9712-38681ec59afb)





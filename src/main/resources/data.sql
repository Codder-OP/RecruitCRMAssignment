-- Insert departments
INSERT INTO department (id, name, budget) VALUES (1, 'Engineering', 500000);
INSERT INTO department (id, name, budget) VALUES (2, 'Marketing', 300000);
INSERT INTO department (id, name, budget) VALUES (3, 'HR', 150000);

-- Insert employees
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES 
(1, 'Om', 'om@example.com', 1, '2020-01-15', 80000, NULL),
(2, 'Ram', 'ram@example.com', 1, '2021-03-20', 75000, 1),
(3, 'Shyam', 'shyam@example.com', 2, '2019-07-10', 70000, 1),
(4, 'Ghanshyam', 'ghyanshyam@example.com', 2, '2022-02-05', 65000, 3),
(5, 'Madhav', 'madhav@example.com', 3, '2023-01-25', 60000, 1);

-- Insert projects
INSERT INTO project (id, name, start_date, end_date, department_id) VALUES
(101, 'Apollo', '2024-01-01', '2025-01-31', 1),
(102, 'Zephyr', '2024-06-01', '2025-04-30', 2),
(103, 'Nova', '2023-03-01', '2024-03-01', 3);

-- Insert employee_project
INSERT INTO employee_project (employee_id, project_id, assigned_date, role) VALUES 
(1, 101, '2024-01-25', 'Lead Engineer'),
(2, 101, '2024-02-01', 'Developer'),
(3, 102, '2024-06-15', 'Marketing Lead'),
(4, 102, '2024-07-01', 'Content Strategist'),
(5, 103, '2023-01-01', 'HR Analyst');

-- Insert performance reviews
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES
(1001, 1, '2023-06-01', 9, 'Excellent'),
(1002, 2, '2023-06-01', 7, 'Good'),
(1003, 3, '2023-06-01', 6, 'Satisfactory'),
(1004, 1, '2022-12-01', 8, 'Very Good'),
(1005, 1, '2021-12-01', 7, 'Good'),
(1006, 4, '2023-06-01', 5, 'Average'),
(1007, 5, '2023-06-01', 6, 'Satisfactory'),
(1008, 2, '2022-12-01', 8, 'Very Good'),
(1009, 3, '2022-06-01', 7, 'Good'),
(1010, 4, '2022-12-01', 6, 'Satisfactory');

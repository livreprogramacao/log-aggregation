# README


How to elaborate a stress test to send 100K string to an endpoint named "/logs" it is RESTful API  using JMeter 


To create a stress test for sending 100,000 strings to a RESTful API endpoint (e.g., `/logs`) using Apache JMeter, follow these detailed steps:

## Setting Up JMeter for Stress Testing

1. **Install JMeter**: If you haven’t done this yet, download JMeter from the [official website](https://jmeter.apache.org/) and install it.

2. **Create a New Test Plan**:
   - Open JMeter.
   - Right-click on "Test Plan" and select **Add > Threads (Users) > Thread Group**.

3. **Configure the Thread Group**:
   - Set the **Number of Threads (users)** to a suitable number (e.g., 1000). This means that JMeter will simulate 1000 users sending requests.
   - Set the **Ramp-Up Period** (e.g., 10 seconds) to spread out the load.
   - Set the **Loop Count** to 100 (since you’re sending 100,000 strings in total, and with 1000 threads, this means each thread would send 100 requests).

4. **Add an HTTP Request Sampler**:
   - Right-click on the Thread Group and select **Add > Sampler > HTTP Request**.
   - Configure the HTTP Request:
     - **Server Name or IP**: Enter the server address.
     - **Port Number**: Enter the port if it differs (e.g., 80 for HTTP).
     - **HTTP Method**: Select **POST** (or **GET** based on your API needs).
     - **Path**: Enter `/logs`.

5. **Configure the Request Body**:
   - In the HTTP Request, locate the **Body Data** section.
   - To send a string, enter a sample string, like `{"message": "your_string_here"}`. If you want to parameterize, use a variable (e.g., `${string}`). 

6. **Add a CSV Data Set Config (if needed)**:
   - If you have different strings you want to send, add a CSV file containing these strings.
   - Right-click on the Thread Group and select **Add > Config Element > CSV Data Set Config**.
   - Configure the CSV Data Set:
     - **Filename**: Path to your CSV file.
     - **Variable Names**: Enter a variable name (e.g., `string`).
     - Set **Recycle on EOF** to **True** if you want to loop through the file.

7. **Add Listeners**:
   - Right-click on the Thread Group and select **Add > Listener > View Results Tree** or **Aggregate Report** to track results.
   - These listeners will help you visualize the test results.

8. **Run the Test**:
   - Save your test plan and click on the green **Start** button.
   - Monitor the listeners for results.

9. **Analyze the Results**:
   - Once the test is complete, examine the results in the listeners you added.
   - Look for response times, throughput, and any error messages.

---

## Example Thread Group Configuration Table

| Parameter             | Value            |
|-----------------------|------------------|
| Number of Threads     | 1000             |
| Ramp-Up Period        | 10 seconds       |
| Loop Count            | 100              |
| HTTP Method           | POST             |
| Path                  | /logs            |
| Variables (if used)   | `${string}`      |

This setup will allow you to simulate the desired load on your API endpoint efficiently. Make sure your server can handle the stress test and be aware of any potential throttling or rate-limiting mechanisms in place.

---
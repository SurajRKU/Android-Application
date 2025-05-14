# About
Code Quiz is an Android Quiz application developed using Java within the Android Studio IDE. Employed XML for user interface design and integrated with a robust firebase authentication service to streamline user registration and login processes. Utilized realtime firebase database service to store user data and quiz questions.
## Project Live Demo
https://github.com/SurajRKU/Android-Application/assets/53537228/4d3d4a29-7cd0-400a-af9f-8566596cb046

## Features:
- **Firebase Authentication** – Implements Firebase authentication service for login and registration using email-password as shown below in figure 1.
- **Smart Question Prioritization** – Implements an adaptive algorithm that categorizes each question by topic (e.g., Arrays, Loops) and tracks user performance. If a 
user frequently answers questions incorrectly in a specific category, the engine prioritizes more questions from that area in future quizzes. It also ensures no repeated questions in subsequent attempts once correctly answered, creating a personalized and efficient learning path.
- **Real-Time Leaderboard** – Displays global user's live scores by accessing Firebase Realtime Database.
- **User Feedback Collection** – Stores structured responses to Firebase, enabling sentiment analysis or future enhancement planning.

## Project Structure
<div align="left">
<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Project_Structure.png" height="600" width="700" />
</div>

## Project Images
### Firebase Structure
<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Realtime_Database.png" height = "250" width="400"/>      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Realtime_Database_Question.png" height = "250" width="400" />
### Authentication Page
<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Code_Quiz_Screen.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Authentication_Screen.jpeg"  height ="650" width="300" />
### Home Screen and Navigation Page
<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Home_Screen.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Navigation_Screen.jpeg"  height ="650" width="300" />
### Profile and Update Page
<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Account_Details_Screen.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Edit_Details_Screen.jpeg"  height ="650" width="300" />
### Quiz and Leaderboard Page
<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Question_Page.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Leaderboard_Screen.jpeg"  height ="650" width="300" />



















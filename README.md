# About
Code Quiz is an Android Quiz application developed using Java within the Android Studio IDE. Employed XML for user interface design and integrated with a robust firebase authentication service to streamline user registration and login processes. Utilized realtime firebase database service to store user data and quiz questions.
## Project Live Demo
https://github.com/SurajRKU/Android-Application/assets/53537228/4d3d4a29-7cd0-400a-af9f-8566596cb046

## Features:
- **Firebase Authentication** – Implements Firebase authentication service for login and registration using email-password.
- **Smart Question Prioritization** – Implements an adaptive algorithm that categorizes each question by topic (e.g., Arrays, Loops) and tracks user performance. If a 
user frequently answers questions incorrectly in a specific category, the engine prioritizes more questions from that area in future quizzes. It also ensures no repeated questions in subsequent attempts once correctly answered, creating a personalized and efficient learning path.
- **Real-Time Leaderboard** – Displays global user's live scores by accessing Firebase Realtime Database.
- **User Feedback Collection** – Stores structured responses to Firebase, enabling sentiment analysis or future enhancement planning.

## Project Structure
The CodeQuiz project follows a modular Android architecture. The java/com/example/firebase4/ folder organizes code into Authentication, Model Classes, Offline and Online Quiz Pages for clarity and functionality. Each handles specific logic—auth with Firebase, quiz data models, and quiz modes. Supporting activities like profile edit, feedback, and leaderboard are included. The res/ folder holds XML layouts (grouped similarly), drawable assets, and values like strings, styles, and colors. The AndroidManifest.xml declares app components and permissions. Gradle files manage dependencies and build settings.

```
CodeQuiz/
├── app/
│   ├── build.gradle                  - App-level config
│   └── src/
│       └── main/
│           ├── java/com/example/firebase4/
│           │   ├── Authentication Pages/  - Auth screens logic
│           │   ├── Model Class Pages/     - Data models
│           │   ├── Offline Quiz Pages/    - Offline quiz backend
│           │   └── Online Quiz Pages/     - Online quiz backend
│           │   ├── EditProfileActivity.java
│           │   ├── FeedbackActivity.java
│           │   ├── LeaderboardActivity.java
│           │   ├── MyAccountActivity.java
│           │   └── MainActivity.java
│
│           ├── res/
│           │   ├── layout/
│           │   │   ├── authentication_pages/
│           │   │   ├── model_class_pages/
│           │   │   ├── offline_quiz_pages/
│           │   │   └── online_quiz_pages/
│           │   │   ├── activity_edit_profile.xml
│           │   │   ├── activity_feedback.xml
│           │   │   ├── activity_leaderboard.xml
│           │   │   ├── activity_my_account.xml
│           │   │   └── activity_main.xml
│
│           ├── values/
│           │   ├── strings.xml       - Text labels
│           │   ├── colors.xml        - App color palette
│           │   └── styles.xml        - Theme and styling
│
│           ├── drawable/             - Icons and images
│           └── mipmap/               - Launcher icons
│           └── AndroidManifest.xml   - App declarations
│
├── build.gradle                      - Root project config
├── settings.gradle                   - Module setup
```

## Project Images
### Firebase Structure
The application leverages Firebase Realtime NoSQL Database for seamless data synchronization and real-time updates. The database is structured into three primary nodes:

**Users_database**: Stores comprehensive user profiles, including authentication details, quiz scores, and response history. This node ensures personalized experiences and tracks user progress dynamically.

**Feedback_database**: Collects and organizes user feedback to drive iterative improvements. Insights from this node inform future enhancements, ensuring the app evolves based on user needs.

**Online_questions**: Contains a curated repository of 400–500 questions sourced from external references. This node powers the quiz functionality, providing a diverse and scalable question bank for both online and offline modes.

<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Realtime_Database.png" height = "250" width="400"/><img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Realtime_Database_Question.png" height = "250" width="400" />

### Authentication Page
The Authentication Pages handle all user access workflows of sign up and login.These pages are integrated with Firebase Authentication, allowing secure and scalable identity management without building a backend from scratch.They ensure that only authenticated users can access quiz functionalities and personal data like scores or feedback.

<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Code_Quiz_Screen.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Authentication_Screen.jpeg"  height ="650" width="300" />

### Home Screen and Navigation Page
The home screen serves as the main dashboard after user login, providing access to both online and offline quiz modes. The online quiz requires an internet connection to retrieve questions from Firebase in real-time, while the offline mode uses locally stored questions for uninterrupted practice. The interface includes quick navigation to account management features, allowing users to view or edit their profile, submit feedback, and logout.

<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Home_Screen.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Navigation_Screen.jpeg"  height ="650" width="300" />

### Profile and Edit Page
The My Account section displays the user's profile information such as name, email, institutional details (college and branch), and their previous quiz score obtained upon playing the online version of the quiz. Users can edit their personal details through dedicated edit buttons for each field, allowing for quick updates to name, educational background, and other profile information. 

<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Account_Details_Screen.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Edit_Details_Screen.jpeg"  height ="650" width="300" />

### Quiz and Leaderboard Page
The quiz presents 3 question sets with 4 options each. Users must complete all questions in a set before advancing. The leaderboard displays the top 20 online quiz scores in descending order, updated in real-time via Firebase. Both online and offline modes share the same clean interface

<img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Question_Page.jpeg" height ="650" width="300"  />      <img src="https://github.com/SurajRKU/Android-Application/blob/master/Application Images/Leaderboard_Screen.jpeg"  height ="650" width="300" />




















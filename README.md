# Fetch Rewards
This is my app that grabs json data from https://fetch-hiring.s3.amazonaws.com/hiring.json and displays it on the screen

The app will automatically grab the data when the main screen is created and display it to the screen once it's loaded

# How to build
In android studio (Once my repo has been cloned) Go to Build -> Build Bundles/Apks -> Build Apk
Then you will find the apk under app -> build -> outputs -> apk -> debug (or release depending on build config) -> app-debug.apk (or release)
You can then install the apk (I use adb to install)

# How to debug
In android studio sync the gradle file
choose your device to deploy to
Then press the debug button at the top
should debug as you run the code

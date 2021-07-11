# automatic-octo-fiesta
![Banner](https://github.com/devrath/automatic-octo-fiesta/blob/main/images/banner.png)


This repository contains a collection of projects and information regarding testing in android 


| Applications | Architecture used |
| ------------ | ----------------- |
| [RecepieApp](https://github.com/devrath/automatic-octo-fiesta/wiki#recepieapp) | |
| [ImdbMoviesApp](https://github.com/devrath/automatic-octo-fiesta/wiki#imdbmoviesapp) | Clean Architecture |


| **`Useful Test Libraries`** | **`Description`** | **`Online link`** |
| --------------------- | ----------- | ------------------------------|
| **Google fluent assertions** | `Truth - Fluent assertions for Java and Android` | [website](https://truth.dev/) |
| **MockWebServer** | `This is used to simulate the remote API locally for instrumentation tests` | [website](https://github.com/square/okhttp/tree/master/mockwebserver) |
| **MockK** | `Helpful for writing unit tests similar to espresso with pure kotlin based DSL` | [website](https://mockk.io/ANDROID.html) |


| About Unit Testing | Test doubles | Templates in test | Test Patterns | Code coverage |
| ------- | ------- | ------- | -------- | -------- |
| [Why testing is Essential](https://github.com/devrath/automatic-octo-fiesta/wiki/Why-testing-is-Essential) | [What is a test double, why we need it](https://github.com/devrath/automatic-octo-fiesta/wiki/What-is-a-test-double,-why-we-need-it) | [**`AAA-Templete`**](https://github.com/devrath/automatic-octo-fiesta/wiki/AAA-Templete) | [Robot Pattern](https://github.com/devrath/automatic-octo-fiesta/wiki/Robot-Pattern) | [JaCoCo](https://github.com/devrath/automatic-octo-fiesta/wiki/JaCoCo) |
| [Testing Pyramid](https://github.com/devrath/automatic-octo-fiesta/wiki/Testing-Pyramid) | [What is mock](https://github.com/devrath/automatic-octo-fiesta/wiki/What-are-mocks) | | |
| [Segregating the tests in android](https://github.com/devrath/automatic-octo-fiesta/wiki/Segregating-the-tests-in-android) | [What is stub](https://github.com/devrath/automatic-octo-fiesta/wiki/What-is-stub) | | |
| [Good practices in testing](https://github.com/devrath/automatic-octo-fiesta/wiki/Good-practices-in-testing) | [What is fake](https://github.com/devrath/automatic-octo-fiesta/wiki/What-is-fake) | | |
| [Annotations Explained](https://github.com/devrath/automatic-octo-fiesta/wiki/Annotations-Explained) | [What is spying](https://github.com/devrath/automatic-octo-fiesta/wiki/What-is-spying) | | |

| Rules used in testing | Testing Coroutines | Using local server | Local DB |
| ------------ | ------------------ | ------------------ | ------------------------------ |
| [What is InstantTaskExecutorRule](https://github.com/devrath/automatic-octo-fiesta/wiki/What-is-InstantTaskExecutorRule) | [Using runBlockingTest](https://github.com/devrath/automatic-octo-fiesta/wiki/Using-runBlockingTest) | [MockWebServer](https://github.com/devrath/automatic-octo-fiesta/wiki/MockWebServer-for-instrumentation-tests) | [Unit tests on RoomDB](https://github.com/devrath/automatic-octo-fiesta/wiki/Unit-tests-on-RoomDB) |
| [What is ActivityTestRule](https://github.com/devrath/automatic-octo-fiesta/wiki/What-is-ActivityTestRule) | [Using TestCoroutineDispatcher](https://github.com/devrath/automatic-octo-fiesta/wiki/Using-TestCoroutineDispatcher) |  

| About MockK | Espresso |
| ------- | ------- |
| [Official Website of MockK](https://mockk.io/ANDROID.html) | [Espresso concepts](https://github.com/devrath/automatic-octo-fiesta/wiki/Espresso-concepts) |
| [Checking if the function call in the view model is invoked](https://github.com/devrath/automatic-octo-fiesta/wiki/Checking-if-the-function-call-in-the-view-model-is-invoked) | [Annotations in espresso](https://github.com/devrath/automatic-octo-fiesta/wiki/Annotations-in-espresso) |
| [Checking if a method in the API interface is called](https://github.com/devrath/automatic-octo-fiesta/wiki/Checking-if-a-method-in-the-API-interface-is-called) | [Espresso Settings](https://github.com/devrath/automatic-octo-fiesta/wiki/Espresso-settings) |
| [Boilerplate code to make threading work on the coroutines in the mockK](https://github.com/devrath/automatic-octo-fiesta/wiki/Boiler-plate-code-to-make-threading-work-on-the-coroutines-in-the-mockK) | [Espresso Cheat Sheet](https://github.com/devrath/automatic-octo-fiesta/wiki/Espresso-Cheat-sheet) |
| [How to mock classes that are not built using the dependency injection principles](https://github.com/devrath/automatic-octo-fiesta/wiki/How-to-mock-classes-that-are-not-built-using-the-dependency-injection-principles) | [Hamcrest Cheat Sheet](https://github.com/devrath/automatic-octo-fiesta/wiki/Hamcrest-Cheat-sheet) |
| | [Espresso test Recorder](https://github.com/devrath/automatic-octo-fiesta/wiki/Espresso-Test-Recorder) | 


## Applications

### *`ImdbMoviesApp`*
**`Correct credentials`**: name: `mail@example.com`, password: `pass`

**`Description`**: In the login screen we are performing the validations on login, if the user enters wrong credentials appropriate message is displayed in the dialog **`->`** If the user enters correct credentials we launch a profile screen **`->`** The profile screen has my movies button **`->`** on click of my movies, we show the list of movies retrieved from the server

* This project is developed using clean architecture. 
* Each task is a use case and runs in a background thread using co-routines and returns results to the main thread.
* Hilt dependency injection is used for injecting the dependencies
* Networking is performed using retrofit 
* Instrumentation and unit tests are written for the screens
* For the Instrumentation tests, we are using a Mock server to run tests so that our tests are not dependent on external service for tests.
* The Instrumentation tests follow robot pattern to separate what from how Thus increasing the lifetime of test cases due to change is a requirement.
* In the unit tests we are using the concept of faking in order to mimic the repository, service, and API involved.

### *`RecepieApp`*

`Description`: In this application, There are some recipes in assets, we need to parse the recipes and display them in a list view, and on click of each row in the recipe list we need to display a detailed screen of that recipe and we can set the recipe as favorite and store the selection in shared preferences.

* Using espresso tool both in *Instrumentation test* and *unit test*
* Setting *custom test runner*, This is useful in switching the mode of storing the key/value pairs for shared preferences
* Using *robot pattern* - > Useful in separating what from how while writing the tests
* Testing elements that involve *context* -> How to test the functions that use context


***

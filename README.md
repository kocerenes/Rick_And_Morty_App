# Rick_And_Morty_App

An application I wrote to learn paging3 and practice client in a clean architecture.

App GIF
--------------
<p align="center">
  <img src="https://github.com/kocerenes/Rick_And_Morty_App/blob/master/gif/rickmorty.gif" alt="GIF" />
</p>

Libraries Used
--------------
* [Architecture][10] - Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [lifecycle][22] - As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle.
  * [Repository][18] - Repository modules handle data operations.
  * [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
  * [View Binding][11] - a feature that allows you to more easily write code that interacts with views.
  * [Navigation][50] - Handle everything needed for in-app navigation.
     asynchronous tasks for optimal execution.
  * [Coroutines][51] - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
  * [livedata][52] - is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
  
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Fragment][34] - A basic unit of composable UI.
  * [Layout][35] - Lay out widgets using different algorithms.
  
* Third party and miscellaneous libraries
  * [Retrofit][90] for turns your HTTP API into a Java interface
  * [Paging3][95] The Paging library helps you load and display pages of data from a larger dataset from local storage or over network.
  * [OkHttp][91] OkHttp is an HTTP client that’s efficient by default
  * [Coil][92] for image loading
  * [Timber][94] This is a logger with a small, extensible API which provides utility on top of Android's normal Log class.
  * [Hilt][93] Hilt is the recommended solution for [dependency injection][21] in Android apps, and works seamlessly with Compose.
  
  
Missing Parts
--------------
Gender and status data are not coming to BottomsheetView. Search operation is not performed.


[11]: https://developer.android.com/topic/libraries/view-binding
[52]: https://developer.android.com/topic/libraries/architecture/livedata
[13]: https://developer.android.com/topic/libraries/data-binding
[51]: https://developer.android.com/kotlin/coroutines
[50]: https://developer.android.com/topic/libraries/architecture/navigation/
[10]: https://developer.android.com/jetpack/compose/architecture
[17]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[18]: https://developer.android.com/jetpack/guide#fetch-data
[90]: https://square.github.io/retrofit/
[92]: https://coil-kt.github.io/coil/compose/
[93]: https://developer.android.com/jetpack/compose/libraries#hilt
[30]: https://developer.android.com/guide/topics/ui
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[94]: https://github.com/JakeWharton/timber
[95]: https://developer.android.com/topic/libraries/architecture/paging/v3-overview
[91]: https://square.github.io/okhttp/
[21]: https://developer.android.com/training/dependency-injection
[22]: https://developer.android.com/guide/components/activities/activity-lifecycle

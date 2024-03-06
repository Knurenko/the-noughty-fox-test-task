# The Noughty Fox test app

## App overview
The project was developed simply to show my Android development skillz

The app contains 2 screens:

1)list of items with short info 

<img width="394" alt="image" src="https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/03efc957-1c39-4fef-9933-d773400904ec">

2) view of one item with full info

<img width="394" alt="image" src="https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/0e5988c7-fef5-4f7a-9623-fe865d24baf0">

  
 both uses [source](https://jsonplaceholder.typicode.com) to fetch data in unsecured way (there is no need to apply any kind of authorization to request headers, if it was, I'd put them in BuildConfig)

## App Architecture overview

The app was developed in "classic" modern way, with MVVM and Clean Architecture
### domain layer:
contains pure business-logic (data model, data repository, possible exceptions)

<img width="229" alt="image" src="https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/db3d7909-af88-461a-8e54-853266497d01">


### data layer:
contains all the things to handle operations with data & network (check internet connection, retrieve data from remote source, convert it to domain-model)

<img width="322" alt="image" src="https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/8e7f2aae-a447-4bf2-9380-955966f46b99">

### presentation layer:
contains all the UI components/screens + navigation
each screen contains 4 files: 
 - AnyScreenState (sealed class to represent all possible screen states)
 - AnyScreenView (pure UI with preview depends on given state value)
 - AnyScreenViewModel (contains flow of current state and functions to perform fetch)
 - AnyScreenRoute (wrapper to inject viewModel & pass all the state/function_calls)



## build'n'run
1) clone the project & open it in Android Studio
2) press Add Configuration


![image](https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/bb06fb09-58e5-4052-ad75-3fc231e37edf)

3) add new configuration

![image](https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/0cbaddbb-ed1c-4371-8033-57f4e29a975c)

4) Name it as you wish and select The_Noughty_fox_Test_App.app.main module

![image](https://github.com/Knurenko/the-noughty-fox-test-task/assets/18510675/a0dbbd22-28f0-4320-8fd6-41b0912ac84d)

5) Press Ok
6) Build project
7) Run the app

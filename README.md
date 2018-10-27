# Architecture

In this project the architecture used has been MVPS. Is like a MVP but adding a State. This State is a inmutable model and is used by the view to render all the data necessary. In the next picture we can see all the architecture used.

![Architecture](https://github.com/cacato86/Test/blob/master/Architecture.jpg)

As you can see in the image, the approach than I'm using only has one entry point in the presenter. The Presenter receive Actions and send State to the view. With this approach I reduce possible bugs and it's easier to debug and test.

There are 3 main modules:

  - UI: In this part we  can find Views (Activities, Fragments, Screens..), Presenters and Mapper(map between Domain and ViewModel). This part is responsable to render the data received by other layers
  - DOMAIN: In this part we can find the UseCases, Repositories and Domain models. In this part we can create the business rules that define the project. The UseCases call the repositories to get the data and does some logic defined by the business rules
  - DATA: In this part we can find DataSources(Api, DataBase, SharedPreferences,...) and Mappers(map between Data and Domain). In this part we can have a lot of DataSource, each one will be responsable to get the data from one source and return a dataModel
  
  Using this tree layers, we can isolate each functionality, make a testable app and avoid most of the bugs that occurs in the normal apps.

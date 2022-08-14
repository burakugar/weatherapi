# weatherapi
Weather Rest Api for openweathermap

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/50373019/184527754-bcfb1cf5-a081-4d8b-bfc9-05ee0bb97cb6.png">

There are 3 end points.

<img width="1422" alt="image" src="https://user-images.githubusercontent.com/50373019/184527771-de9937bf-7404-4eca-bde8-d7c7bf57a389.png">

When post mapping executed, it takes appid for confirmation on openweathermap and city name.
If there is no city with given name, following exception will be executed.
<img width="1419" alt="image" src="https://user-images.githubusercontent.com/50373019/184528148-642447f7-7f6a-4378-bfd7-51dc2d01e71d.png">

<img width="1437" alt="image" src="https://user-images.githubusercontent.com/50373019/184528105-8841d1e2-e3a0-4ade-a2e0-f788df15987e.png">

When post mapping executed, it takes appid for confirmation on openweathermap and city name.
For example:
appid:
4c344d36ad5873f72159782522511528
cityname: Istanbul

<img width="1419" alt="image" src="https://user-images.githubusercontent.com/50373019/184527835-4c7292a6-fbf3-4f96-895f-8c0918ee84b1.png">

For Prague:

<img width="1428" alt="image" src="https://user-images.githubusercontent.com/50373019/184527868-066f2faa-d0b7-4edd-afe6-7b9b664d26ee.png">

<img width="545" alt="image" src="https://user-images.githubusercontent.com/50373019/184527854-f03988cb-40e7-40c8-971c-3cabbdde4ae2.png">

The api endpoint will return the highest and lowest degrees and also cityID.

If the same city is requested again, it will return an exception.

<img width="970" alt="image" src="https://user-images.githubusercontent.com/50373019/184527915-5dab4309-93ec-4d96-a84c-20e1a6b75028.png">

Cities are stored in a HashMap inside of the CityStoreService. When the application finish, the storage will be destroyed.

Second GET endpoint will return the all cities.

<img width="1423" alt="image" src="https://user-images.githubusercontent.com/50373019/184527941-a191b15b-9369-4d8d-a2f4-d0ab98b83f02.png">

Third endpoint will take a cityID from one of the cities which is already added into list and return the informations of that city.

<img width="1435" alt="image" src="https://user-images.githubusercontent.com/50373019/184528034-de0c3028-ff62-4afb-888f-29f86189b8bb.png">

If the city not in the list, it will return an exception:

<img width="1399" alt="image" src="https://user-images.githubusercontent.com/50373019/184528059-d37d91e2-f115-4f28-98e3-98373b0bee6d.png">


<img width="1435" alt="image" src="https://user-images.githubusercontent.com/50373019/184527984-5f41da88-314a-44ba-806d-b6c9ef25e691.png">


# FetchDemo

Demonstrate modern android app architectual approach (MVVM + Clean architecture)

## Requirement

Please write a native Android app in Kotlin or Java that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.

Display this list of items to the user based on the following requirements:

- Display all the items grouped by "listId"
- Sort the results first by "listId" then by "name" when displaying.
- Filter out any items where "name" is blank or null.
  
The final result should be displayed to the user in an easy-to-read list.

## Architecture Diagram

<img src="https://github.com/ChuliangYang/FetchDemo/blob/main/Arch%20diagram.png" alt="Architecture Diagram" width="1200" height="1000"/>

## Tech Stack

- MVVM + Clean
- Compose UI
- Flow + coroutine
- Retrofit

## Screen
<img src="https://github.com/ChuliangYang/FetchDemo/raw/main/Screenshot_20240922_172726.png" alt="Screen" width="300" height="600"/>


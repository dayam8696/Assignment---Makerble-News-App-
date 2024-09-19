# News App

A simple news application built using the [News API](https://newsapi.org/) that displays breaking news and allows users to save and manage their favorite news articles. The app consists of two primary screens: **Breaking News** and **Saved News**.

## Features

- **Breaking News Screen**: 
  - Displays an infinite list of news articles in a `RecyclerView`.
  - Each news article is displayed on a card with a headline and a short description.
  - Clicking on a news card opens the detailed news article in a web view.
  - Includes a Heart button in detailed section to save articles for later viewing.
  
- **Saved News Screen**:
  - Displays all news articles saved by the user.
  - Users can swipe left or right to delete any saved news article from the list.
  
## Screenshots

### Breaking News Screen
![Breaking News Screen](./Screenshots/BreakingNews.jpg)




## Tech Stack

- **Language**: Kotlin
- **UI Layout**: XML
- **Networking**: Retrofit for API calls
- **Data Storage**: SharedPreferences or Room Database (for saving news articles)
- **UI Components**: `RecyclerView`, `Swipeable Cards`, `WebView`
- **API**: [News API](https://newsapi.org/)

## Getting Started

### Prerequisites

- Android Studio 4.0 or higher
- Kotlin support enabled in Android Studio
- A [News API](https://newsapi.org/) key for fetching news articles

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/news-app.git
    cd news-app
    ```

2. **Obtain your API key** from [News API](https://newsapi.org/) and add it to the project. Create a `local.properties` file in the root directory (if it doesn't exist) and add the following line:
    ```
    NEWS_API_KEY=your_api_key_here
    ```

3. **Open the project** in Android Studio.

4. **Build the project** and run it on an Android emulator or a physical device.

### How to Use

1. **Breaking News**:
    - Browse the latest breaking news articles on the main screen.
    - Click on any news card to view the detailed article in the app’s web view.
    - To save a news article, click the Heart icon on the card. The article will be added to the Saved News screen.

2. **Saved News**:
    - Navigate to the Saved News screen to view all the articles you have saved.
    - Swipe left or right on any card to remove it from the saved articles.

## Contributing

Contributions are welcome! Feel free to submit issues or pull requests for new features, improvements, or bug fixes.

### Steps to Contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

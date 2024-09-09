# ToDoList Application

This is a simple Todolist application that uses MongoDB Atlas as its database. Follow the instructions below to set up and run the application on your local machine.


![Application](https://raw.githubusercontent.com/ulaecio/todolist/main/todolist-1.PNG)

![Mongo DataBase](https://raw.githubusercontent.com/ulaecio/todolist/main/todolist-2.PNG)

## Prerequisites

Before you begin, make sure you have the following installed on your system:

- [Node.js](https://nodejs.org/) (v18.x or higher)
- [npm](https://www.npmjs.com/get-npm) (v10.x or higher)
- [MongoDB Atlas Account](https://www.mongodb.com/cloud/atlas) (for creating a cloud database)
- 
Start by cloning the repository to your local machine:

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/kaffa-mobile-test.git
cd ToDoList
```


### 2. Running the Server

1. Navigate to the `ToDoList/server` directory:

    ```bash
    cd server
    ```

2. Install the server dependencies:

    ```bash
    npm install
    ```

3. Start the server:

    ```bash
    npm start
    ```

   The server should now be running on `http://localhost:5000`.

### 3. Running the Frontend Application

1. Open a new terminal and navigate to the `ToDoList/client` directory:

    ```bash
    cd client
    ```

2. Install the frontend dependencies:

    ```bash
    npm install
    ```

3. Start the frontend application:

    ```bash
    npm start
    ```

   The frontend should now be running on `http://localhost:3000`.

### 4. Configuring Proxy (Optional)

If your frontend application makes API requests to the backend, you may need to set up a proxy in the frontend to avoid CORS issues. To do this, add the following line to the `client/package.json` file:

```json
"proxy": "http://localhost:5000"
```

# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.
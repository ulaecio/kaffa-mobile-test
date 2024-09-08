const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();
app.use(express.json());
app.use(cors());

// Connect to MongoDB
mongoose.connect('mongodb+srv://meusdadosum:myqLbxNeFHqj93jj@cluster-ulasoftware.o82m8.mongodb.net', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

// Define a schema and model for Todo items
const todoSchema = new mongoose.Schema({
    text: String,
});

const Todo = mongoose.model('Todo', todoSchema);

// API routes
app.get('/todos', async (req, res) => {
    const todos = await Todo.find();
    res.json(todos);
});

app.post('/todos', async (req, res) => {
    const newTodo = new Todo({
        text: req.body.text,
    });
    await newTodo.save();
    res.json(newTodo);
});

app.delete('/todos/:id', async (req, res) => {
    await Todo.findByIdAndDelete(req.params.id);
    res.json({ message: 'Todo deleted' });
});

// Start the server
app.listen(5000, () => {
    console.log('Server is running on port 5000');
});

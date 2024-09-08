import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
    const [todos, setTodos] = useState([]);
    const [text, setText] = useState('');

    useEffect(() => {
        fetchTodos();
    }, []);

    const fetchTodos = async () => {
        const res = await axios.get('http://localhost:5000/todos');
        setTodos(res.data);
    };

    const addTodo = async () => {
        if (text.trim()) {
            const res = await axios.post('http://localhost:5000/todos', { text });
            setTodos([...todos, res.data]);
            setText('');
        }
    };

    const deleteTodo = async (id) => {
        await axios.delete(`http://localhost:5000/todos/${id}`);
        setTodos(todos.filter(todo => todo._id !== id));
    };

    return (
      <div class="todo-container">
      <h1 class="todo-title">ToDo List</h1>
      <div class="todo-input-container">
          <input
              type="text"
              class="todo-input"
              value={text}
              onChange={(e) => setText(e.target.value)}
              placeholder="Insira uma tarefa..."
          />
          <button class="todo-add-button" onClick={addTodo}>Adicionar</button>
      </div>
      <ul class="todo-list">
          {todos.map(todo => (
              <li class="todo-item" key={todo._id}>
                  {todo.text}
                  <button class="todo-delete-button" onClick={() => deleteTodo(todo._id)}>Excluir</button>
              </li>
          ))}
      </ul>
  </div>
  
    );
}

export default App;

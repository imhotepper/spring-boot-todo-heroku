
app = new Vue({
  el:'#vue-app',
  data:{
    title:'my todos!',
    newTodo:'',
    todos:[],
    completedTodos:[],
    selectedTodos:[]
  },
  methods:{
  addTodo: function(){
    axios.post('/api/todos', {title:this.newTodo, isCompleted: false})
    .then((response)=> {

                        this.todos.push(response.data);
                        this.newTodo ='';
                        })

    .catch((err)=> console.log('error: ',err))
        console.log('adding new todo: ', this.newTodo);
    },
    completeTodo: function(){
      var that = this;
        this.selectedTodos.map(function(item){
            axios.post(`/api/todos/${item}/complete`)
                .then(function(response) {
                    //todo: remove from one list and add to another
                    let completed = response.data;
                    that.completedTodos.push(completed);
                    that.todos = that.todos.filter((x)=> x.id != completed.id);
                    that.selectedTodos = [];
                    console.log('got back completed: ', response.data );
                })
                .catch((err)=> console.log('error: ', err));
        });
    },
    deleteTodo: function(id){
        var that = this;
        axios.delete(`/api/todos/${id}`)
                        .then(function(response) {
                            //todo: remove from one list and add to another
                            let deleted = response.data;
                            that.completedTodos = that.completedTodos.filter((x)=> x.id != deleted.id);
                            console.log('got back for deleted: ', response.data );
                        })
                        .catch((err)=> console.log('error deleting: ', err));
    }
  },
  created: function(){
    axios.get('/api/todos')
        .then((response) =>{
            console.log('data in:' ,response);
            response.data.map((x)=>
            x.isCompleted == true ?
                     this.completedTodos.push(x) : this.todos.push(x));
           // this.todos = response.data
        }
         )
        .catch((err) => console.log('Error: ', err));
    console.log('app created');
    }
})


Vue.component('todo-component', {
    template: '#todo-component',
    data: function () {

    }
    });
fun main(args: Array<String>) {
    val taskList = mutableListOf<Task>()

    while (true) {
        println("Menu:")
        println("1. Add Task")
        println("2. Mark Task as Completed")
        println("3. View Tasks")
        println("4. Exit")
        print("Enter your choice: ")

        val choice = readlnOrNull()?.toIntOrNull()

        when (choice) {
            1 -> addTask(taskList)
            2 -> markTaskAsCompleted(taskList)
            3 -> viewTasks(taskList)
            4 -> return
            else -> println("Invalid choice. Please try again.")
        }
    }
}



fun addTask(taskList: MutableList<Task>) {
    print("Enter task name: ")
    val taskName = readlnOrNull() ?: ""
    val task = Task(taskName)
    taskList.add(task)
    println("Task added successfully.")
}

fun markTaskAsCompleted(taskList: MutableList<Task>) {
    if (taskList.isEmpty()) {
        println("No tasks available.")
        return
    }

    println("Select the index of the task to mark as completed:")
    for ((index, task) in taskList.withIndex()) {
        println("$index. ${task.name} - Completed: ${task.isBoolean}")
    }

    val taskIndex = readlnOrNull()?.toIntOrNull()
    if (taskIndex != null && taskIndex in 0..<taskList.size) {
        taskList[taskIndex].isBoolean = true
        println("Task marked as completed.")
    } else {
        println("Invalid index.")
    }
}

fun viewTasks(taskList: List<Task>) {
    if (taskList.isEmpty()) {
        println("No tasks available.")
        return
    }

    println("Tasks:")
    for (task in taskList) {
        println("${task.name} - Completed: ${task.isBoolean}")
    }
}
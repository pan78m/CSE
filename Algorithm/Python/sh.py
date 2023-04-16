import tkinter as tk
from tkinter import messagebox

class HomeSection(tk.Frame):
    def __init__(self, master):
        super().__init__(master)
        self.master = master
        self.master.title("Data Structures")
        self.master.geometry("400x300")
        
        # Add buttons for different data structures
        self.array_button = tk.Button(self, text="Array", command=self.array_clicked)
        self.array_button.pack(pady=10)
        
        self.linked_list_button = tk.Button(self, text="Linked List", command=self.linked_list_clicked)
        self.linked_list_button.pack(pady=10)
        
        self.stack_button = tk.Button(self, text="Stack", command=self.stack_clicked)
        self.stack_button.pack(pady=10)
        
        self.queue_button = tk.Button(self, text="Queue", command=self.queue_clicked)
        self.queue_button.pack(pady=10)
        
        self.tree_button = tk.Button(self, text="Tree", command=self.tree_clicked)
        self.tree_button.pack(pady=10)
        
        self.pack()
        
    def array_clicked(self):
        # Code to handle the Array button click
        print("Array button clicked")
        
         self.home_frame.withdraw()
         self.array_frame.deiconify()

    def linked_list_clicked(self):
        # Code to handle the Linked List button click
        print("Linked List button clicked")
        
    def stack_clicked(self):
        # Code to handle the Stack button click
        print("Stack button clicked")
        
    def queue_clicked(self):
        # Code to handle the Queue button click
        print("Queue button clicked")
        
    def tree_clicked(self):
        # Code to handle the Tree button click
        print("Tree button clicked")


        class ArraySection(tk.Frame):
    def __init__(self, master):
        super().__init__(master)
        self.master = master
        self.master.title("Array Section")
        self.master.geometry("400x300")
        
        # Create widgets for array section
        self.array_size_label = tk.Label(self, text="Enter array size:")
        self.array_size_label.pack(pady=10)
        self.array_size_entry = tk.Entry(self)
        self.array_size_entry.pack(pady=10)
        
        self.array_values_label = tk.Label(self, text="Enter array values (comma separated):")
        self.array_values_label.pack(pady=10)
        self.array_values_entry = tk.Entry(self)
        self.array_values_entry.pack(pady=10)
        
        self.add_button = tk.Button(self, text="Add", command=self.add_data)
        self.add_button.pack(pady=10)
        
        self.search_button = tk.Button(self, text="Search", command=self.search_data)
        self.search_button.pack(pady=10)
        
        self.insert_button = tk.Button(self, text="Insert", command=self.insert_data)
        self.insert_button.pack(pady=10)
        
        self.delete_button = tk.Button(self, text="Delete", command=self.delete_data)
        self.delete_button.pack(pady=10)
        
        self.update_button = tk.Button(self, text="Update", command=self.update_button)
        self.update_button.pack(pady=10)

        
if __name__ == "__main__":
    root = tk.Tk()
    app = HomeSection(root)
    root.mainloop()

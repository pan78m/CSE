import tkinter as tk
from tkinter import messagebox

class MainApplication(tk.Tk):
    def __init__(self):
        super().__init__()

        # Set up the main window
        self.title("Array/Link List")
        self.geometry("300x100")

        # Create the buttons
        self.array_btn = tk.Button(self, text="Array", command=self.open_array_window)
        self.array_btn.pack(side="left", padx=10, pady=10)
        self.link_list_btn = tk.Button(self, text="Link List", command=self.open_link_list_window)
        self.link_list_btn.pack(side="left", padx=10, pady=10)
        self.tree_btn = tk.Button(self, text="Tree", command=self.open_tree_window)
        self.tree_btn.pack(side="left", padx=10, pady=10)
        self.sorts_btn = tk.Button(self, text="Sorts", command=self.open_sorts_window)
        self.sorts_btn.pack(side="left", padx=10, pady=10)


    def open_array_window(self):
        # Destroy the main window
        self.withdraw()

        # Open the Array Window
        self.array_window = ArrayWindow()

    def open_link_list_window(self):
        # Destroy the main window
        self.withdraw()

        # Open the Link List Window
        self.link_list_window = LinkListWindow()

    def open_tree_window(self):
        tree_window = tk.Toplevel(self)
        tree_window.title("Tree Window")
        # Add widgets and functionality to the tree window here

    def open_sorts_window(self):
        sorts_window = tk.Toplevel(self)
        sorts_window.title("Sorts Window")
        # Add widgets and functionality to the sorts window here


class ArrayWindow(tk.Toplevel):
    def __init__(self):
        super().__init__()

        # Set up the array window
        self.title("Array")
        self.geometry("300x150")

        # Create the labels and entries
        self.num_elements_label = tk.Label(self, text="Enter number of elements:")
        self.num_elements_label.pack(side="top", padx=10, pady=5)
        self.num_elements_entry = tk.Entry(self)
        self.num_elements_entry.pack(side="top", padx=10, pady=5)
        self.elements_label = tk.Label(self, text="Enter elements separated by commas:")
        self.elements_label.pack(side="top", padx=10, pady=5)
        self.elements_entry = tk.Entry(self)
        self.elements_entry.pack(side="top", padx=10, pady=5)

        # Create the Create button
        self.create_btn = tk.Button(self, text="Create", command=self.create_array)
        self.create_btn.pack(side="top", padx=10, pady=5)

    def create_array(self):
        self.withdraw()
        num_elements = int(self.num_elements_entry.get())
        elements = self.elements_entry.get().split(",")
        elements = [int(e.strip()) for e in elements]
        self.array = elements

        # Open the Array Display window
        self.array_display_window = ArrayDisplayWindow(self.array)


class ArrayDisplayWindow(tk.Toplevel):
    def __init__(self, array):
        super().__init__()

        # Set up the array display window
        self.title("Array Display")
        self.geometry("300x150")

        # Display the array
        self.array_label = tk.Label(self, text="Array: " + str(array))
        self.array_label.pack(side="top", padx=10, pady=5)

        # Create the Insert and Delete buttons
        self.insert_btn = tk.Button(self, text="Insert", command=self.insert_element)
        self.insert_btn.pack(side="left", padx=10, pady=10)
        self.delete_btn = tk.Button(self, text="Delete", command=self.delete_element)
        self.delete_btn.pack(side="right", padx=10, pady=10)

    def insert_element(self):
        # Create a new window to get the new element to be inserted
        self.insert_window = tk.Toplevel(self)
        self.insert_window.title("Insert Element")
        self.insert_window.geometry("200x100")

        # Create a label and entry for the new element
        self.new_element_label = tk.Label(self.insert_window, text="Enter the new element to be inserted:")
        self.new_element_label.pack(side="top", padx=10, pady=5)
        self.new_element_entry = tk.Entry(self.insert_window)
        self.new_element_entry.pack(side="top", padx=10, pady=5)

        # Create the Insert button
        self.insert_btn = tk.Button(self.insert_window, text="Insert", command=self.insert_element_helper)
        self.insert_btn.pack(side="top", padx=10, pady=5)

    def insert_element_helper(self):
        # Get the new element from the entry widget
        new_element = self.new_element_entry.get()

        # Check if the input is a valid integer
        try:
            new_element = int(new_element)
        except ValueError:
            # Display an error message if the input is not a valid integer
            self.error_label = tk.Label(self.insert_window, text="Invalid input. Please enter an integer.")
            self.error_label.pack(side="top", padx=10, pady=5)
            return

        # Add the new element to the end of the array
        self.array.extend(new_element)
        self.array_label.config(text="Array: " + str(self.array))

        # Close the insert window
        self.insert_window.destroy()

    def delete_element(self):
        # Create a new top-level window to get the index of the element to be deleted
        self.index_window = tk.Toplevel(self)
        self.index_window.title("Delete Element")
        self.index_window.geometry("200x100")

        # Create a label and entry widget to get the index from the user
        self.index_label = tk.Label(self.index_window, text="Enter the index of the element to be deleted (0-" + str(
            len(self.array) - 1) + "):")
        self.index_label.pack(side="top", padx=10, pady=5)

        self.index_entry = tk.Entry(self.index_window)
        self.index_entry.pack(side="top", padx=10, pady=5)

        # Create a button to submit the index
        self.submit_btn = tk.Button(self.index_window, text="Delete",
                               command=lambda: self.do_delete_element(self.index_entry.get(), self.index_window))
        self.submit_btn.pack(side="top", padx=10, pady=10)

    def do_delete_element(self, index_str, index_window):
        # Check if the input is a valid integer
        try:
            index = int(index_str)
            if 0 <= index < len(self.array):
                # Remove the element from the array and update the display
                del self.array[index]
                self.array_label.config(text="Array: " + str(self.array))
        except ValueError:
            # Display an error message if the input is not a valid integer
            tk.messagebox.showerror("Error", "Invalid input: please enter a valid integer index.")

        # Close the index window
        self.index_window.destroy()


class LinkListWindow(tk.Toplevel):
    def __init__(self):
        super().__init__()

        # Set up the link list window
        self.title("Link List")
        self.geometry("300x150")

        # TODO: Implement the Link List window


if __name__ == "__main__":
    app = MainApplication()
    app.mainloop()
import tkinter as tk


class Raj:
    def __init__(self, master):
        self.updated_value_entry = None
        self.current_value_entry = None
        self.array_update_entry = None
        self.array_delete_entry = None
        self.array_insert_entry = None
        self.array_search_element = None
        self.master = master
        self.current_interface = 0
        self.array_size = 0
        self.array = []

        self.home_interface()

    def home_interface(self):
        self.current_interface = 0
        self.master.title("Basic Data Structures")
        tk.Label(self.master, text="Choose a Data Structure:", font="Arial, 40 bold", bg="azure4").pack(pady=30)
        tk.Button(self.master, text="Array", font="Sans-serif, 20 bold", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.array_interface).pack(pady=5)
        tk.Button(self.master, text="Linked List", font="Sans-serif, 20", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey").pack(pady=5)
        tk.Button(self.master, text="Stack", font="Sans-serif, 20", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey").pack(pady=5)
        tk.Button(self.master, text="Queue", font="Sans-serif, 20", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey").pack(pady=5)
        tk.Button(self.master, text="Graph", font="Sans-serif, 20", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey").pack(pady=5)
        tk.Button(self.master, text="Trees", font="Sans-serif, 20", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey").pack(pady=5)

    def array_interface(self):
        # self.current_interface = 1
        # self.master.title("Array")

        self.ary= tk.Toplevel(bg="azure4")
        self.ary.title("Array")
        self.ary.geometry("900x600+300+80")
        tk.Label(self.ary, text="Enter the size of array:", font="Sans-serif, 20 bold", bg="azure4").pack(pady=10)
        self.array_size_entry = tk.Entry(self.ary, width="15", font="Arial 24")
        self.array_size_entry.pack(pady=5)
        tk.Button(self.ary, text="Next", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.create_array).place(x=455,y=107)
        tk.Button(self.ary, text="Back", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.ary.destroy).place(x=390, y=107)

    def create_array(self):

        self.array_size = int(self.array_size_entry.get())
        self.array_interface_2()

    def array_interface_2(self):
        # self.arr = tk.Toplevel()
        # self.arr.title("Array")
        self.current_interface = 2
        # self.master.title("Arrays: Input Elements")
        tk.Label(self.ary, text="Enter array elements:", font="Sans-serif, 20 bold", bg="azure4").pack(pady=10)
        self.array_entries = []
        for i in range(self.array_size):
            entry = tk.Entry(self.ary, width="17", font="Arial 20")
            entry.pack(pady=2)
            self.array_entries.append(entry)
        tk.Button(self.ary, text="Next", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.show_array).pack(pady=5)
        tk.Button(self.ary, text="Back", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.ary.destroy).pack()

    def show_array(self):
        self.out= tk.Toplevel(bg="azure4")
        self.out.title("Arrays: Operations")
        self.out.geometry("900x600+300+80")
        # self.current_interface = 3
        # self.master.title("Arrays: Operations")
        self.array = []
        for entry in self.array_entries:
            self.array.append(int(entry.get()))
        tk.Label(self.out, text="Array: " + str(self.array), font="Sans-serif, 30 bold", bg="azure4").pack(pady=30)
        tk.Button(self.out, text="Search", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.array_search).pack(pady=10)
        tk.Button(self.out, text="Insert", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey",command=self.array_insert).pack(pady=10)
        tk.Button(self.out, text="Delete", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey",command=self.array_delete).pack(pady=10)
        tk.Button(self.out, text="Update", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey",command=self.array_update).pack(pady=10)
        tk.Button(self.out, text="Back", font="Sans-serif, 15", bg="black", fg="white", activeforeground="white", activebackground="grey",command=self.out.destroy).pack(pady=50)
        tk.Button(self.out, text="EXIT", font="Sans-serif, 15", bg="black", fg="white", activeforeground="white", activebackground="grey", command=self.master.destroy).place(x=419, y=450)

    def array_search(self):
        # code for search operation
        # Function to search for an element in the array
        # self.current_interface = 4
        # self.master.title("Search Operation")
        self.src= tk.Toplevel(bg="azure4")
        self.src.title("Search Operation")
        self.src.geometry("900x600+300+80")
        tk.Label(self.src, text="Enter the element you want to search:", font="Sans-serif, 20 bold", bg="azure4").pack(pady=10)
        self.array_search_element = tk.Entry(self.src, width="15", font="Arial 24")
        self.array_search_element.pack(pady=5)
        tk.Button(self.src, text="Next", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.search_interface).pack(pady=5)
        tk.Button(self.src, text="Back", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.src.destroy).pack()

    def search_interface(self):
        self.z= self.array_search_element.get()
        if self.z in self.array:
            tk.Label(self.src, text=self.array_search_element.get() + " found in the Array:" + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack(pady=5)

        else:
            tk.Label(self.src, text=self.array_search_element.get() + " not found in the Array:" + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack(pady=5)



    def array_insert(self):
        # code for insert operation
        # Function to insert an element into the array
        # self.current_interface = 5
        # self.master.title("Insert Operation")
        self.insrt= tk.Toplevel(bg="azure4")
        self.insrt.title("Insert Operation")
        self.insrt.geometry("900x600+300+80")
        tk.Label(self.insrt, text="Enter the element you want to insert:", font="Sans-serif, 20 bold", bg="azure4").pack(pady=10)
        self.array_insert_entry = tk.Entry(self.insrt, width="15", font="Arial 24")
        self.array_insert_entry.pack(pady=5)
        tk.Button(self.insrt, text="Next", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.insert_interface).pack(pady=5)
        tk.Button(self.insrt, text="Back", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.insrt.destroy).pack()

    def insert_interface(self):

        self.array.append(int(self.array_insert_entry.get()))
        tk.Label(self.insrt, text="\nAfter inserting " + self.array_insert_entry.get() + "\n\n Updated array: " + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack(pady=20)
        tk.Button(self.insrt, text="Go to Array Home", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.insrt.destroy).pack()

    def array_delete(self):
        # code for delete operation
        # Function to delete an element from the array
        # self.current_interface = 6
        # self.master.title("Delete Operation")
        self.dlt= tk.Toplevel(bg="azure4")
        self.dlt.title("Delete Operation")
        self.dlt.geometry("900x600+300+80")
        tk.Label(self.dlt, text="Enter the index number you want to delete:" + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack(pady=10)
        self.array_delete_entry = tk.Entry(self.dlt, width="15", font="Arial 24")
        self.array_delete_entry.pack(pady=5)
        tk.Button(self.dlt, text="Next", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.delete_interface).pack(pady=5)
        tk.Button(self.dlt, text="Back", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.dlt.destroy).pack()

    def delete_interface(self):
        # element = input("Enter the element to delete: ")
        # if self.array_delete_entry.get() in str(self.array):
        self.x= int(self.array_delete_entry.get())
        self.array.__delitem__(self.x)
        tk.Label(self.dlt, text="\nAfter deleting index No.  " + self.array_delete_entry.get() + "\n\n Updated array: " + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack(pady=20)
        tk.Button(self.dlt, text="Go to Array Home", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.dlt.destroy).pack()
        # print("Element deleted. Updated array:", str(self.array))
        # else:

        # tk.Label(self.master, text="The element not found in the array: " + str(self.array)).pack()
        # print("Element not found.")
        pass

    def array_update(self):
        # code for update operation
        # Function to update an element in the array
        # self.current_interface = 7
        # self.master.title("Update Operation")
        self.updt= tk.Toplevel(bg="azure4")
        self.updt.title("Update Operation")
        self.updt.geometry("900x600+300+80")
        tk.Label(self.updt, text="Enter the index no. and value respectively:", font="Sans-serif, 20 bold", bg="azure4").pack(pady=10)
        # self.array_update_entry = tk.Entry(self.master)
        self.current_value_index = tk.Entry(self.updt, width="15", font="Arial 24")
        self.current_value_index.pack(pady=2)
        self.updated_value = tk.Entry(self.updt, width="15", font="Arial 24")
        self.updated_value.pack()
        # self.array_update_entry.pack()
        tk.Button(self.updt, text="Next", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.update_interface).pack(pady=5)
        tk.Button(self.updt, text="Back", font="Sans-serif, 15", bg="Lightsteelblue2", fg="black", activeforeground="white", activebackground="grey", command=self.updt.destroy).pack()

    def update_interface(self):
        # current_value = input("Enter the current value of the element: ")
        # updated_value = input("Enter the updated value of the element: ")
        self.x = int(self.current_value_index.get())
        self.y = self.updated_value
        self.array.insert(self.x, self.y)
        # if self.current_value_entry.get() in self.array:
        #     index = self.array.index(self.current_value_entry.get())
        #     (self.array)[index] = self.updated_value_entry.get()
        tk.Label(self.updt, text="After updating the element\n Updated array: " + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack()
        #
        # # print("Element updated. Updated array:", str(self.array))
        # else:
        # tk.Label(self.updt, text="The element not found in the array: " + str(self.array), font="Sans-serif, 20 bold", bg="azure4").pack()
        #     # print("Element not found.")
        #
        # pass

root = tk.Tk()
root.geometry("900x600+300+80")
root.config(bg="azure4")
app = Raj(root)
root.mainloop()

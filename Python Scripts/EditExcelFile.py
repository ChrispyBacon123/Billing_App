import openpyxl as pyxl
import os

def update_excel(name, phone, email,no_people,date,duration):
    """Updates ICF Coaching hours spreadsheet"""
    wb = pyxl.load_workbook("<EXCEL FILE>")
    sheet = wb.active
    data = [name,phone,email,no_people,date,duration]
    sheet.append(data)
    wb.save(filename="<EXCEL FILE>")

def extract_data_from_text_file(folder_path):
    """Gets Client details from folder to generate invoice"""
    try:
        # List all files in the specified folder
        files = os.listdir(folder_path)
        data = []

        # Find the first text file in the folder
        for file in files:
            if file.endswith("UpdateExcel.txt"):
                text_file_path = os.path.join(folder_path, file)

                # Read and extract data from the text file
                with open(text_file_path, 'r') as file_content:
                    data = file_content.readlines()
                    for item in data:
                        item.strip()
                    return data

        # If no text file is found
        print("No text file found in the folder.")
        return None

    except Exception as e:
        print(f"An error occurred: {e}")
        return None

def delete_files():
    """Deletes the text file from the file buffer"""
   
    try:
        folder_path="<FILE BUFFER PATHWAY>"
        # List all files in the specified folder
        files = os.listdir(folder_path)

        # Find and delete files with the specified pattern
        for file in files:
            if file.endswith("UpdateExcel.txt"):
                file_path = os.path.join(folder_path, file)
                os.remove(file_path)

    except Exception as e:
        print(f"An error occurred: {e}")


def main():
    data = extract_data_from_text_file("<FILE BUFFER PATHWAY>")
    update_excel(data[0],data[1],data[2],data[3],data[4],data[5])
    delete_files()

if __name__ == "__main__":
    main()

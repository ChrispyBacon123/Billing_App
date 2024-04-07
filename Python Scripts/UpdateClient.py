import dropbox
import dropbox.files
import os


with open("<TOKEN FILE PATHWAY>","r") as f:
        TOKEN = f.read()
dbx = dropbox.Dropbox(TOKEN)
dbx.check_and_refresh_access_token()


def upload_files_to_folder(file_name):
    """Uploads all the files from the buffer folder to a specific folder in Dropbox"""
    for file in os.listdir("<FILE BUFFER PATHWAY>"):
        if file.endswith(".DS_Store") is False:
            with open(os.path.join("<FILE BUFFER PATHWAY>",file), "rb") as f:
                data = f.read()
                delFile=file_name+file
                dbx.files_delete_v2(delFile)
                dbx.files_upload(data, file_name+f"{file}")

def delete_files():
    """Deletes the text file from the file buffer"""
   
    try:
        folder_path="<FILE BUFFER PATHWAY>"
        # List all files in the specified folder
        files = os.listdir(folder_path)

        # Find and delete files with the specified pattern
        for file in files:
            if file.endswith(".txt"):
                file_path = os.path.join(folder_path, file)
                os.remove(file_path)

    except Exception as e:
        print(f"An error occurred: {e}")


def extract_data_from_text_file():
    """Gets Client details from folder to generate folder"""
    try:
        # List all files in the specified folder
        files = os.listdir("<FILE BUFFER PATHWAY>")
        
        # Find the first text file in the folder
        for file in files:
            if file.endswith(".DS_Store") is False:
                with open(os.path.join("<FILE BUFFER PATHWAY>", file), "rb") as f:
                    data = f.readline().decode('utf-8').strip()
                    return data

        print("No suitable text file found in the folder.")
        return None

    except Exception as e:
        print(f"An error occurred: {e}")
        return None
    

def main():
    folder_name=extract_data_from_text_file()
    folder = f"/Clients/{folder_name}/"
    upload_files_to_folder(folder)
    delete_files()
    folder_path="<FILE BUFFER PATHWAY>"
    files = os.listdir(folder_path)
    print("Update Client files:")
    print(files)



if __name__ == "__main__":
    main()
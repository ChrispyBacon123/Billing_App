import dropbox
import dropbox.files
import os


with open("token.txt","r") as f:
        TOKEN = f.read()
dbx = dropbox.Dropbox(TOKEN)
dbx.check_and_refresh_access_token()

def update_excel(file_name):
    """Uploads all the files from the buffer folder to a specific folder in Dropbox"""
    for file in os.listdir("<EXCEL PATHWAY>"):
        if file.endswith(".DS_Store") is False:
            with open(os.path.join("<EXCEL PATHWAY",file), "rb") as f:
                data = f.read()
                print(file_name+f"{file}\n\n\n\n")
                dbx.files_delete("/Coaching Hours")
                dbx.files_upload(data, file_name+f"{file}")


def upload_files_to_folder(file_name):
    """Uploads all the files from the buffer folder to a specific folder in Dropbox"""
    for file in os.listdir("<FILE BUFFER PATHWAY>"):
        if file.endswith(".DS_Store") is False:
            with open(os.path.join("<FILE BUFFER PATHWAY>",file), "rb") as f:
                data = f.read()
                dbx.files_upload(data, file_name+f"{file}")


def create_dropbox_folder(folder_name):
    """Enter a name in as a parameter and it will be created in dropbox"""
    folder_name="Clients/"+folder_name
    path = f"/{folder_name}"
    
        # Printing the path for debugging
    print(f"Constructed path: {path}")
    try:
        dbx.files_create_folder(f"/{folder_name}")
        print(f"Folder '{folder_name}' created successfully in Dropbox.")

    except dropbox.exceptions.ApiError as e:
        print(f"Error creating folder: {e}")

def main():
    folder_name=""
    # folder = f"/Clients/{folder_name}/"
    # create_dropbox_folder(folder_name)
    # upload_files_to_folder(folder)



if __name__ == "__main__":
    main()

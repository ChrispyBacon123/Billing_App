import dropbox
import dropbox.files
import os


with open("<TOKEN FILE PATHWAY>","r") as f:
        TOKEN = f.read()
dbx = dropbox.Dropbox(TOKEN)
dbx.check_and_refresh_access_token()

def update_excel(file_name):
    """Uploads all the files from the buffer folder to a specific folder in Dropbox"""
    for file in os.listdir("<EXCEL FILE PATHWAY>"):
        if file.endswith(".DS_Store") is False:
            with open(os.path.join("<EXCEL FILE PATHWAY>",file), "rb") as f:
                data = f.read()
                dbx.files_delete("/Coaching Hours")
                dbx.files_upload(data, file_name+f"{file}")


def main():
    file_name=f"/Coaching Hours/"
    update_excel(file_name)


if __name__ == "__main__":
    main()

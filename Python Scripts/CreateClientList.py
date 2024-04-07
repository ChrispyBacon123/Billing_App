import dropbox
import os



def process_dropbox_folder(dbx, source_folder, output_file):
    try:
        # List all files and folders in the specified Dropbox folder
        entries = dbx.files_list_folder(source_folder).entries

        # Open the output file for appending
        with open(output_file, 'a') as output_file:
            for entry in entries:
                if isinstance(entry, dropbox.files.FolderMetadata):
                    folder_name = entry.name
                    if folder_name != "Coaching Hours":
                        # Construct the file path of the text file within the folder
                        file_path = f"{source_folder}/{folder_name}/{folder_name}.txt"

                        try:
                            # Download the text file content
                            _, response = dbx.files_download(file_path)
                            content = response.content.decode('utf-8').splitlines()

                            # Write the first 3 lines to the output file
                            output_file.write(f"{content[0]}#{content[1]}#{content[2]}#{content[3]}\n")

                            print(f"Processed folder '{folder_name}'")

                        except dropbox.exceptions.ApiError as e:
                            print(f"\n\nError downloading file from folder '{folder_name}': {e}")

    except dropbox.exceptions.ApiError as e:
        print(f"Error listing files in folder '{source_folder}': {e}")


def main():
    with open("/Users/CrispyBacon/Desktop/Mumsle App/token.txt","r") as f:
        TOKEN = f.read()
    dbx = dropbox.Dropbox(TOKEN)
    dbx.check_and_refresh_access_token()
    # Specify the source folder in Dropbox to process
    source_folder = f"/Clients"  # Change this to the actual path

    # Specify the output file path
    output_file = '/Users/CrispyBacon/Desktop/Mumsle App/Client List.txt'

    # Call the function to process the Dropbox folder and append to the output file
    process_dropbox_folder(dbx, source_folder, output_file)
    
if __name__ == "__main__":
    main()

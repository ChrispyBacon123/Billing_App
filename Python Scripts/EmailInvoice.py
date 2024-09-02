import smtplib
import os
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.application import MIMEApplication
import tkinter as tk
from tkinter import messagebox

def send_email_with_attachment(recipient_email,file_name,date):
    """Sends an email to the client including the invoice"""
    # Set up the sender email address and app password (replace with your values)
    sender_email = '<EMAIL ADRESS HERE>'
    app_password = 'APP PASSWORD HERE'


   
  
    # Attach the document

    file = "<EMAIL BUFFER PATHWAY>"+file_name
    # Create the MIME object
    message = MIMEMultipart()
    message['From'] = sender_email
    message['To'] = recipient_email
    message['Subject'] = 'Invoice for Coaching Session on '+date

    # Add the email body
    body = f"Hi there! I hope you are well!\n Here's the latest invoice for our session on {date}.\n\n"
    message.attach(MIMEText(body, 'plain'))

    with open(file, "rb") as file:
       attachment = MIMEApplication(file.read(), Name=file_name)

    attachment["Content-Disposition"] = f"attachment; filename={file_name}"
    message.attach(attachment)

     # Attach Regards
    body = "<PLACE REGARDS>"
    message.attach(MIMEText(body,'plain'))

    # Set up the SMTP server
    smtp_server = 'smtp.gmail.com'
    smtp_port = 587

    # Establish a connection to the SMTP server
    server = smtplib.SMTP(smtp_server, smtp_port)
    server.starttls()

    # Log in to the email account
    server.login(sender_email, app_password)

    # Send the email
    server.sendmail(sender_email, recipient_email, message.as_string())

    # Quit the server
    server.quit()

def delete_files():
    """Deletes the Invoice from the file buffer"""
    try:
        folder_path="<FILE BUFFER PATHWAY>"
        # List all files in the specified folder
        files = os.listdir(folder_path)

        # Find and delete files with the specified pattern
        for file in files:
            file_path = os.path.join(folder_path, file)
            os.remove(file_path)
            print("Deleted Email.txt")
        
        folder_path="<EMAIL BUFFER PATHWAY>"
        # List all files in the specified folder
        files = os.listdir(folder_path)

        # Find and delete files with the specified pattern
        for file in files:
            file_path = os.path.join(folder_path, file)
            os.remove(file_path)
            print("Deleted Email Doc")
        

    except Exception as e:
        print(f"An error occurred: {e}")

def get_email():
     """Gets the data from the textfile"""
     folder_path="<FILE BUFFER PATHWAY>"
     try:
        # List all files in the specified folder
        files = os.listdir(folder_path)
        data = []

        # Find the first text file in the folder
        for file in files:
            if file.endswith("Email.txt"):
                text_file_path = os.path.join(folder_path, file)

                # Read and extract data from the text file
                with open(text_file_path, 'r') as file_content:
                    data = file_content.readlines()
                    for item in data:
                        item.strip()
                    folder_path="<FILE BUFFER PATHWAY>"
                    files = os.listdir(folder_path)
                    print("\n\nFiles before email:")
                    print(files)
                    return data

        # If no text file is found
        print("No text file found in the folder.")
        return None

     except Exception as e:
        print(f"An error occurred: {e}")
        return None


def main():
    file = os.listdir("<FILE BUFFER PATHWAY>")
    doc = os.listdir("<EMAIL BUFFER PATHWAY>")
    print("files in doc:")
    print(str(doc)+"\n\n\n")
    data = get_email()      
    send_email_with_attachment(data[0],doc[0],data[1])
    delete_files()

if __name__ == "__main__":
    main()

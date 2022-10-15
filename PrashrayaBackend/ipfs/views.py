from urllib import response
from django.shortcuts import render , redirect , HttpResponse
from ipfs.models import File_Upload
import requests 

def handle_upload(request):
    if request.method == "POST":
        FileName = request.POST.get('FileName')
        file = request.FILES['file'] 
        upload_file = {
            'file' : file,
        }
        response = requests.post('http://127.0.0.1:5001/api/v0/add', files=upload_file)
        data = response.json()
        hash = data['Hash']
        a1 = File_Upload(FileName=FileName,hash = hash)
        a1.save()
        return redirect('/')

def fetch_all(request):
    if request.method == "GET":
        data = File_Upload.objects.values_list('hash')
        return HttpResponse(data, content_type='application/json')
        
def get_file(request):
    if request.method == "POST":
        hash = request.POST.get('hash')
        url = "http://127.0.0.1:8080/ipfs/"+hash
        return redirect(url)

from django.urls import path , include
from . import views

urlpatterns = [
    path('inapp/sendfile', views.handle_upload,name='sendfile'),
    path('inapp/allnames', views.fetch_all,name='getall'),
    path('inapp/getfile', views.get_file,name='getfile'),
]
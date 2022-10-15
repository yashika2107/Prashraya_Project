from django.db import models

class File_Upload(models.Model):
    FileName = models.CharField(max_length=255, blank=False, null=False)
    hash = models.CharField(max_length=255, blank=True, null=True)
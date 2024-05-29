#!/usr/bin/env python
# coding: utf-8

# In[1]:


#importing basic packages
import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
import joblib
import inputScript

URLfeatures = inputScript.main("http://appleid.apple.com-sa.pm")
print (URLfeatures[0])
data1=URLfeatures
data = np.array(data1).reshape(1, -1)
print(data)
from tensorflow.keras.models import load_model

model= load_model('phishing.h5')
print("Phishing Website Detection")
features = data#URLfeatures[0]#data #np.array([[1,1,-1,1,1,1,-1,1,-1,1,1,-1,1,0,1,1,1,1,0,1,1,1,1,1,-1,1,-1,1,-1,1]])
phd=model.predict(features)[0]
print(phd)
if(phd>0.98):
    print("not phising Site")
else:
    print("phising site")

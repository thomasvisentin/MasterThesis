import glob
import os
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from IPython.display import display
import numpy as np



allFolders = []

rootdir = '/root/Desktop/fou'
for file in os.listdir(rootdir):
    d = os.path.join(rootdir, file)
    if os.path.isdir(d):
        allFolders.append(d)
        
GlobalComplexity = 0.0
CombinationGlobalComplexity = ""

eta_1 = 0
eta_2 = 0
N_1 = 0
N_2 = 0
value = 0

for i in range(0, len(allFolders)):
    Current_eta_1 = 0
    Current_eta_2 = 0
    Current_N_1 = 0
    Corrent_N_2 = 0
    Current_value = 0
    CurrentGlobalComplexity = 0.0
    if i % 1000 == 0:
        print(i)
    HalsteadPath = allFolders[i] + "/h-" + allFolders[i][18:] + ".txt"
    McCabePath = allFolders[i] + "/mc-" +allFolders[i][18:] + ".txt"
    try:
        fileHalstead = open(HalsteadPath, 'r')
        Lines = fileHalstead.readlines()
        for x in range(39):
            if x == 24:
                splitter = Lines[x].split("= ")
                CurrentGlobalComplexity = CurrentGlobalComplexity + (float(splitter[1])/148) #substitute the donominator with the the global maximum of the metric
                Current_eta_1 = splitter[1]
            if x == 25:
                splitter = Lines[x].split("= ")
                CurrentGlobalComplexity = CurrentGlobalComplexity + (float(splitter[1])/655) #substitute the donominator with the the global maximum of the metric
                Current_eta_2 = splitter[1]
            if x == 26:
                splitter = Lines[x].split("= ")
                CurrentGlobalComplexity = CurrentGlobalComplexity + (float(splitter[1])/25810) #substitute the donominator with the the global maximum of the metric
                Current_N_1 = splitter[1] 
            if x == 27:
                splitter = Lines[x].split("= ")
                CurrentGlobalComplexity = CurrentGlobalComplexity + (float(splitter[1])/6588) #substitute the donominator with the the global maximum of the metric
                Current_N_2 = splitter[1]    
        fileMcCabe = open(McCabePath, 'r')
        Lines = fileMcCabe.readlines()
        for x in range(4):
            if x == 3:
                splitter = Lines[x].split("= ")
                CurrentGlobalComplexity = CurrentGlobalComplexity + (float(splitter[1])/940) #substitute the donominator with the the global maximum of the metric
                Current_value = splitter[1]
        if i % 2 == 1 and CurrentGlobalComplexity > GlobalComplexity:
            GlobalComplexity = CurrentGlobalComplexity
            CombinationGlobalComplexity = HalsteadPath
            eta_1 = Current_eta_1
            eta_2 = Current_eta_2
            N_1 = Current_N_1
            N_2 = Current_N_2
            value = Current_value
            
                      
    except:
        pass
        
print(GlobalComplexity)
print(CombinationGlobalComplexity)
print(eta_1 + "\n")
print(eta_2 + "\n")
print(N_1 + "\n")
print(N_2 + "\n")
print(value + "\n")

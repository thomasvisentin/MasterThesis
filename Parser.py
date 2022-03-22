import glob
import os
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from IPython.display import display
import numpy as np


path = 'G:\\cartella\\one'

files = os.listdir(path)

directory = "G:\\cartella\\one"
pathname = directory + "/**/*.txt"
files = glob.glob(pathname, recursive=True)



print(files[0][16:])

eta_1 = []
eta_2 = []
N_1 = []
N_2 = []
calculated_length = []
volume = []
difficulty = []
effort = []
time_to_program = []
delivered_bugs = []


E = []
N = []
P = []
value = []



for i in range(0, len(files)):
    c = u'\\\\?\\G:\\cartella\\one\\';

    c += files[i][16:]


    if 'h-' in c:

        if os.path.isfile(c):
            file1 = open(c, 'r')
            Lines = file1.readlines()
            for x in range(39):
                if x == 24:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    eta_1.append(float(splitter[1]))
                if x == 25:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    eta_2.append(float(splitter[1]))
                if x == 26:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    N_1.append(float(splitter[1]))
                if x == 27:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    N_2.append(float(splitter[1]))
                if x == 33:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    calculated_length.append(float(splitter[1]))
                if x == 34:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    volume.append(float(splitter[1]))
                if x == 35:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    difficulty.append(float(splitter[1]))
                if x == 36:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    effort.append(float(splitter[1]))
                if x == 37:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    time_to_program.append(float(splitter[1]))
                if x == 38:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    delivered_bugs.append(float(splitter[1]))

        print('-------------------------------------------------------------')

    else:

        if os.path.isfile(c):
            print(True)
            file1 = open(c, 'r')
            Lines = file1.readlines()
            for x in range(4):
                if x == 0:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    E.append(float(splitter[1]))
                if x == 1:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    N.append(float(splitter[1]))
                if x == 2:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    P.append(float(splitter[1]))
                if x == 3:
                    splitter = Lines[x].split("= ")
                    print(float(splitter[1]))
                    value.append(float(splitter[1]))



dict = {#'name': files,
        '\u03b7\u2081': eta_1,
        '\u03b7\u2082': eta_2,
        'N\u2081': N_1,
        'N\u2082': N_2,
        'Calculated length':  calculated_length,
        'Volume': volume,
        'Difficulty' : difficulty,
        'Effort': effort,
        'Time to program': time_to_program,
        'Delivered bugs': delivered_bugs,
        'E': E,
        'N': N,
        'P': P,
        'Value': value
        }
df = pd.DataFrame(dict)

index_max_eta_1 = 0
index_max_eta_2 = 0
index_max_N_1 = 0
index_max_N_2 = 0
index_max_calculated_length = 0
index_max_volume = 0
index_max_difficulty = 0
index_max_effort = 0
index_max_time_to_program = 0
index_max_delivered_bugs = 0
index_max_E = 0
index_max_N = 0
index_max_P = 0
index_max_value = 0

for i in range(0, len(calculated_length)):
    if eta_1[index_max_eta_1] < eta_1[i]:
        index_max_eta_1 = i
    if eta_2[index_max_eta_2] < eta_2[i]:
        index_max_eta_2 = i
    if N_1[index_max_N_1] < N_1[i]:
        index_max_N_1 = i
    if N_2[index_max_N_2] < N_2[i]:
        index_max_N_2 = i
    if calculated_length[index_max_calculated_length] < calculated_length[i]:
        index_max_calculated_length = i
    if volume[index_max_volume] < volume[i]:
        index_max_calculated_length = i
    if difficulty[index_max_difficulty] < calculated_length[i]:
        index_max_difficulty = i
    if effort[index_max_effort] < effort[i]:
        index_max_effort = i
    if time_to_program[index_max_time_to_program] < time_to_program[i]:
        index_max_time_to_program = i
    if delivered_bugs[index_max_delivered_bugs] < delivered_bugs[i]:
        index_max_delivered_bugs = i
    if E[index_max_E] < E[i]:
        index_max_E = i
    if N[index_max_N] < N[i]:
        index_max_N = i
    if P[index_max_P] < P[i]:
        index_max_P = i
    if value[index_max_value] < value[i]:
        index_max_value = i

print("eta_1     " + str(index_max_eta_1) + "     " +  str(eta_1[index_max_eta_1]))
print("eta_2     " + str(index_max_eta_2) + "     " +  str(eta_2[index_max_eta_2]))
print("N_1     " + str(index_max_N_1) + "     " +  str(N_1[index_max_N_1]))
print("N_2     " + str(index_max_N_2) + "     " +  str(N_2[index_max_N_2]))
print("calculated_length     " + str(index_max_calculated_length) + "     " +  str(calculated_length[index_max_calculated_length]))
print("volume     " + str(index_max_volume) + "     " + str(volume[index_max_volume]))
print("difficulty     " + str(index_max_difficulty) + "     " + str(difficulty[index_max_difficulty]))
print("effort     " + str(index_max_effort) + "     " + str(effort[index_max_effort]))
print("time_to_program     " + str(index_max_time_to_program) + "     " + str(time_to_program[index_max_time_to_program]))
print("delivered_bugs     " + str(index_max_delivered_bugs) + "     " + str(delivered_bugs[index_max_delivered_bugs]))
print("E     " + str(index_max_E) + "     " + str(E[index_max_E]))
print("N     " + str(index_max_N) + "     " + str(N[index_max_N]))
print("P     " + str(index_max_P) + "     " + str(P[index_max_P]))
print("value     " + str(index_max_value) + "     " + str(value[index_max_value]))


corr = df.corr()


for i in range(0,10):
    print('{:.2f}'.format(corr.iat[i, 0]) + "  " + '{:.2f}'.format(corr.iat[i, 1]) + "  " + '{:.2f}'.format(corr.iat[i, 2]) + "  " + '{:.2f}'.format(corr.iat[i, 3]) + "  " + '{:.2f}'.format(corr.iat[i, 4]) + "  " + '{:.2f}'.format(corr.iat[i, 5]) + "  " + '{:.2f}'.format(corr.iat[i, 6]) + "  " + '{:.2f}'.format(corr.iat[i, 7]) + "  " + '{:.2f}'.format(corr.iat[i, 8]) + "  " + '{:.2f}'.format(corr.iat[i, 9]))


hm = sns.heatmap(df.corr(),
                 annot= True,
                 cbar=True, #disegna una barra con l'intensità del colore
                 square=True, #forza le caselle a una dimensione quadrata
                 yticklabels=df.columns, #labels per i valori sull'asse Y
                 xticklabels=df.columns) #labels per i valori sull'asse X
plt.show()
print("ok")

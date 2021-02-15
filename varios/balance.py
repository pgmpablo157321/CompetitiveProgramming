import gym
import numpy as np
env = gym.make('Pendulum-v0')
env.reset()

#para poner los angulos en un rango
def angle_normalize(x):
    return (((x+np.pi) % (2*np.pi)) - np.pi)

#se definen los movimientos posibles
moves=np.arange(-1.,1., 0.02)

#funcion de recompensa



#dict q


#funcion q
def Q(theta, thetadot):
    pass

#parametros de la funcion
gamma = 0.75
alfa=0.70
initial_state = [0,0]

for _ in range(1000):
    env.render()
    theta, thetadot = env.state
    if(thetadot>0):
        env.step([.05]) # take a random action
    else:
        env.step([-.05])
    print(angle_normalize(theta))
env.close()
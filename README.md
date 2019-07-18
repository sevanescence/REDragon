# REDragon
RE:Dragon allows ender dragon eggs to drop from all ender dragon deaths after the first ender dragon.

config.yml
```yml
#######################
# RE: DRAGON v1.0.0   #
#######################
# configuration file  #
#######################

# leave this empty, or write "null", to disable
egg-drop-message: "&8[&dRE:Dragon&8] &7The dragon egg has dropped at &b%drop-location%&7!"

# this is what the coordinates will look like
drop-location-format: "&bX:%x%&7, &bY:%y%&7, &bZ:%z%"
```

# Changelog
### 1.0
```diff
RE:Dragon released.
+ Dragon Eggs are placed beneath ender dragons upon death.
+ Configurable egg drop message with drop location placeholder.
+ Configurable drop location placeholder format with x, y, and z coordinates.
```

# todo
- [ ] check if ender dragon death is the first by checking if the egg has spawned along 0 y 0
- [ ] check if the last block is a non-solid block i.e. water, lava, rather than just air
- [ ] add world placeholder
- [ ] play sound effect when egg is dropped

## Arch

### Config
`--store=./store`

`superior spring config: ./config`

### Storage

/{store dir}  
-- /{default}  
---- /{vi dir}  
-- /{other groups}  
---- /{vi dir}  

### DataItem
> data item <=> directory

`.signature` | `.c2lnbmF0dXJl`: all files' unique signature in this item. mark whether change or not.

`.iteminfo` | `.aXRlbWluZm8`: a json serialization of this data item. 

`itemcover` | `aXRlbWNvdmVy`: as the cover image of the item.


### Group
> all directories under store dir.

`.groupinfo` | `Z3JvdXBpbmZv`: a json serialization of Group.


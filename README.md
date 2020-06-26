# AssociationRulesUsingWeka
Example using Apriori algorithm from weka jar tool.
For testing this algorithms is used data.arff with relationship state, money spent and amount of purchases of 146 user.
For use Apriori algorithm you need Discretize your data, 
in this case was used Discretize class of weka.filters.unsupervised.attribute package using 10 bins (default value).
# Weka dependency
```
<dependency>
	<groupId>nz.ac.waikato.cms.weka</groupId>
		<artifactId>weka-stable</artifactId>
	<version>3.8.0</version>
</dependency>
```
# data.arff (extract)
```
@Relation data

@Attribute state {KS,CA,NH,OR,TX,PR,NV,KY,OH,GU,NY,HI,NM,IN,MS,DC,NE,WV,MO,FL,ME,AR,CT,WI,NC,RI,OK,ID,GA,MN,PA,AK,MD,LA,MT,IL,TN,NJ,WA,MI,MA,AL,UT,VT,CO,SC,VI,VA,DE,AZ}
@Attribute spending REAL
@Attribute purchases REAL

@Data
MD,3195.85,148
GA,8241.99,36
CA,3450.95,50
MD,46886.11,257
```
# data discretized (extract)
```
@relation data-weka.filters.unsupervised.attribute.Discretize-B8-M-1.0-R2-3

@attribute state {KS,CA,NH,OR,TX,PR,NV,KY,OH,GU,NY,HI,NM,IN,MS,DC,NE,WV,MO,FL,ME,AR,CT,WI,NC,RI,OK,ID,GA,MN,PA,AK,MD,LA,MT,IL,TN,NJ,WA,MI,MA,AL,UT,VT,CO,SC,VI,VA,DE,AZ}
@attribute spending {'\'(-inf-48558.70375]\'','\'(48558.70375-97115.3475]\'','\'(97115.3475-145671.99125]\'','\'(145671.99125-194228.635]\'','\'(194228.635-242785.27875]\'','\'(242785.27875-291341.9225]\'','\'(291341.9225-339898.56625]\'','\'(339898.56625-inf)\''}
@attribute purchases {'\'(-inf-301.375]\'','\'(301.375-601.75]\'','\'(601.75-902.125]\'','\'(902.125-1202.5]\'','\'(1202.5-1502.875]\'','\'(1502.875-1803.25]\'','\'(1803.25-2103.625]\'','\'(2103.625-inf)\''}

@data
MD,'\'(-inf-48558.70375]\'','\'(-inf-301.375]\''
GA,'\'(-inf-48558.70375]\'','\'(-inf-301.375]\''
CA,'\'(-inf-48558.70375]\'','\'(-inf-301.375]\''
```
# Best rules found:
```
1. purchases='(-inf-241.3]' 223 ==> spending='(-inf-38847.375]' 216    <conf:(0.97)> lift:(1.11) lev:(0.05) [21] conv:(3.51)
2. state=MD purchases='(-inf-241.3]' 51 ==> spending='(-inf-38847.375]' 49    <conf:(0.96)> lift:(1.1) lev:(0.01) [4] conv:(2.14)
3. purchases='(241.3-481.6]' 152 ==> spending='(-inf-38847.375]' 140    <conf:(0.92)> lift:(1.05) lev:(0.02) [7] conv:(1.47)
```
# Rule 2 Explanation
Maryland users who make up to 241 purchases spend up to 38847.

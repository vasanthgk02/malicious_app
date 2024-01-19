package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import java.util.Iterator;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;

public class PDStructureElement extends PDStructureNode {
    public static final String TYPE = "StructElem";

    public PDStructureElement(String str, PDStructureNode pDStructureNode) {
        super((String) TYPE);
        setStructureType(str);
        setParent(pDStructureNode);
    }

    private Map<String, Object> getRoleMap() {
        PDStructureTreeRoot structureTreeRoot = getStructureTreeRoot();
        if (structureTreeRoot != null) {
            return structureTreeRoot.getRoleMap();
        }
        return null;
    }

    private PDStructureTreeRoot getStructureTreeRoot() {
        PDStructureNode parent = getParent();
        while (parent instanceof PDStructureElement) {
            parent = ((PDStructureElement) parent).getParent();
        }
        if (parent instanceof PDStructureTreeRoot) {
            return (PDStructureTreeRoot) parent;
        }
        return null;
    }

    public void addAttribute(PDAttributeObject pDAttributeObject) {
        COSArray cOSArray;
        COSName cOSName = COSName.A;
        pDAttributeObject.setStructureElement(this);
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSArray) {
            cOSArray = (COSArray) dictionaryObject;
        } else {
            COSArray cOSArray2 = new COSArray();
            if (dictionaryObject != null) {
                cOSArray2.add(dictionaryObject);
                cOSArray2.add((COSBase) COSInteger.get(0));
            }
            cOSArray = cOSArray2;
        }
        getCOSDictionary().setItem(cOSName, (COSBase) cOSArray);
        cOSArray.add((COSObjectable) pDAttributeObject);
        cOSArray.add((COSBase) COSInteger.get((long) getRevisionNumber()));
    }

    public void addClassName(String str) {
        COSArray cOSArray;
        if (str != null) {
            COSName cOSName = COSName.C;
            COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(cOSName);
            if (dictionaryObject instanceof COSArray) {
                cOSArray = (COSArray) dictionaryObject;
            } else {
                COSArray cOSArray2 = new COSArray();
                if (dictionaryObject != null) {
                    cOSArray2.add(dictionaryObject);
                    cOSArray2.add((COSBase) COSInteger.get(0));
                }
                cOSArray = cOSArray2;
            }
            getCOSDictionary().setItem(cOSName, (COSBase) cOSArray);
            cOSArray.add((COSBase) COSName.getPDFName(str));
            cOSArray.add((COSBase) COSInteger.get((long) getRevisionNumber()));
        }
    }

    public void appendKid(PDMarkedContent pDMarkedContent) {
        if (pDMarkedContent != null) {
            appendKid((COSBase) COSInteger.get((long) pDMarkedContent.getMCID()));
        }
    }

    public void attributeChanged(PDAttributeObject pDAttributeObject) {
        COSName cOSName = COSName.A;
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            for (int i = 0; i < cOSArray.size(); i++) {
                if (cOSArray.getObject(i).equals(pDAttributeObject.getCOSObject())) {
                    int i2 = i + 1;
                    if (cOSArray.get(i2) instanceof COSInteger) {
                        cOSArray.set(i2, (COSBase) COSInteger.get((long) getRevisionNumber()));
                    }
                }
            }
            return;
        }
        COSArray cOSArray2 = new COSArray();
        cOSArray2.add(dictionaryObject);
        cOSArray2.add((COSBase) COSInteger.get((long) getRevisionNumber()));
        getCOSDictionary().setItem(cOSName, (COSBase) cOSArray2);
    }

    public String getActualText() {
        return getCOSDictionary().getString(COSName.ACTUAL_TEXT);
    }

    public String getAlternateDescription() {
        return getCOSDictionary().getString(COSName.ALT);
    }

    public Revisions<PDAttributeObject> getAttributes() {
        Revisions<PDAttributeObject> revisions = new Revisions<>();
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(COSName.A);
        if (dictionaryObject instanceof COSArray) {
            Iterator<COSBase> it = ((COSArray) dictionaryObject).iterator();
            PDAttributeObject pDAttributeObject = null;
            while (it.hasNext()) {
                COSBase next = it.next();
                if (next instanceof COSDictionary) {
                    pDAttributeObject = PDAttributeObject.create((COSDictionary) next);
                    pDAttributeObject.setStructureElement(this);
                    revisions.addObject(pDAttributeObject, 0);
                } else if (next instanceof COSInteger) {
                    revisions.setRevisionNumber(pDAttributeObject, ((COSInteger) next).intValue());
                }
            }
        }
        if (dictionaryObject instanceof COSDictionary) {
            PDAttributeObject create = PDAttributeObject.create((COSDictionary) dictionaryObject);
            create.setStructureElement(this);
            revisions.addObject(create, 0);
        }
        return revisions;
    }

    public Revisions<String> getClassNames() {
        COSName cOSName = COSName.C;
        Revisions<String> revisions = new Revisions<>();
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSName) {
            revisions.addObject(((COSName) dictionaryObject).getName(), 0);
        }
        if (dictionaryObject instanceof COSArray) {
            Iterator<COSBase> it = ((COSArray) dictionaryObject).iterator();
            String str = null;
            while (it.hasNext()) {
                COSBase next = it.next();
                if (next instanceof COSName) {
                    str = ((COSName) next).getName();
                    revisions.addObject(str, 0);
                } else if (next instanceof COSInteger) {
                    revisions.setRevisionNumber(str, ((COSInteger) next).intValue());
                }
            }
        }
        return revisions;
    }

    public String getElementIdentifier() {
        return getCOSDictionary().getString(COSName.ID);
    }

    public String getExpandedForm() {
        return getCOSDictionary().getString(COSName.E);
    }

    public String getLanguage() {
        return getCOSDictionary().getString(COSName.LANG);
    }

    public PDPage getPage() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.PG);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDPage(cOSDictionary);
    }

    public PDStructureNode getParent() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.P);
        if (cOSDictionary == null) {
            return null;
        }
        return PDStructureNode.create(cOSDictionary);
    }

    public int getRevisionNumber() {
        return getCOSDictionary().getInt(COSName.R, 0);
    }

    public String getStandardStructureType() {
        String structureType = getStructureType();
        if (!getRoleMap().containsKey(structureType)) {
            return structureType;
        }
        Object obj = getRoleMap().get(structureType);
        return obj instanceof String ? (String) obj : structureType;
    }

    public String getStructureType() {
        return getCOSDictionary().getNameAsString(COSName.S);
    }

    public String getTitle() {
        return getCOSDictionary().getString(COSName.T);
    }

    public void incrementRevisionNumber() {
        setRevisionNumber(getRevisionNumber() + 1);
    }

    public void insertBefore(COSInteger cOSInteger, Object obj) {
        insertBefore((COSBase) cOSInteger, obj);
    }

    public void removeAttribute(PDAttributeObject pDAttributeObject) {
        COSName cOSName = COSName.A;
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            cOSArray.remove(pDAttributeObject.getCOSObject());
            if (cOSArray.size() == 2 && cOSArray.getInt(1) == 0) {
                getCOSDictionary().setItem(cOSName, cOSArray.getObject(0));
            }
        } else {
            if (dictionaryObject instanceof COSObject) {
                dictionaryObject = ((COSObject) dictionaryObject).getObject();
            }
            if (pDAttributeObject.getCOSObject().equals(dictionaryObject)) {
                getCOSDictionary().setItem(cOSName, (COSBase) null);
            }
        }
        pDAttributeObject.setStructureElement(null);
    }

    public void removeClassName(String str) {
        if (str != null) {
            COSName cOSName = COSName.C;
            COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(cOSName);
            COSName pDFName = COSName.getPDFName(str);
            if (dictionaryObject instanceof COSArray) {
                COSArray cOSArray = (COSArray) dictionaryObject;
                cOSArray.remove((COSBase) pDFName);
                if (cOSArray.size() == 2 && cOSArray.getInt(1) == 0) {
                    getCOSDictionary().setItem(cOSName, cOSArray.getObject(0));
                }
            } else {
                if (dictionaryObject instanceof COSObject) {
                    dictionaryObject = ((COSObject) dictionaryObject).getObject();
                }
                if (pDFName.equals(dictionaryObject)) {
                    getCOSDictionary().setItem(cOSName, (COSBase) null);
                }
            }
        }
    }

    public void removeKid(COSInteger cOSInteger) {
        removeKid((COSBase) cOSInteger);
    }

    public void setActualText(String str) {
        getCOSDictionary().setString(COSName.ACTUAL_TEXT, str);
    }

    public void setAlternateDescription(String str) {
        getCOSDictionary().setString(COSName.ALT, str);
    }

    public void setAttributes(Revisions<PDAttributeObject> revisions) {
        COSName cOSName = COSName.A;
        int i = 0;
        if (revisions.size() == 1 && revisions.getRevisionNumber(0) == 0) {
            PDAttributeObject pDAttributeObject = (PDAttributeObject) revisions.getObject(0);
            pDAttributeObject.setStructureElement(this);
            getCOSDictionary().setItem(cOSName, (COSObjectable) pDAttributeObject);
            return;
        }
        COSArray cOSArray = new COSArray();
        while (i < revisions.size()) {
            PDAttributeObject pDAttributeObject2 = (PDAttributeObject) revisions.getObject(i);
            pDAttributeObject2.setStructureElement(this);
            int revisionNumber = revisions.getRevisionNumber(i);
            if (revisionNumber >= 0) {
                cOSArray.add((COSObjectable) pDAttributeObject2);
                cOSArray.add((COSBase) COSInteger.get((long) revisionNumber));
                i++;
            } else {
                throw new IllegalArgumentException("The revision number shall be > -1");
            }
        }
        getCOSDictionary().setItem(cOSName, (COSBase) cOSArray);
    }

    public void setClassNames(Revisions<String> revisions) {
        if (revisions != null) {
            COSName cOSName = COSName.C;
            int i = 0;
            if (revisions.size() == 1 && revisions.getRevisionNumber(0) == 0) {
                getCOSDictionary().setName(cOSName, (String) revisions.getObject(0));
                return;
            }
            COSArray cOSArray = new COSArray();
            while (i < revisions.size()) {
                String str = (String) revisions.getObject(i);
                int revisionNumber = revisions.getRevisionNumber(i);
                if (revisionNumber >= 0) {
                    cOSArray.add((COSBase) COSName.getPDFName(str));
                    cOSArray.add((COSBase) COSInteger.get((long) revisionNumber));
                    i++;
                } else {
                    throw new IllegalArgumentException("The revision number shall be > -1");
                }
            }
            getCOSDictionary().setItem(cOSName, (COSBase) cOSArray);
        }
    }

    public void setElementIdentifier(String str) {
        getCOSDictionary().setString(COSName.ID, str);
    }

    public void setExpandedForm(String str) {
        getCOSDictionary().setString(COSName.E, str);
    }

    public void setLanguage(String str) {
        getCOSDictionary().setString(COSName.LANG, str);
    }

    public void setPage(PDPage pDPage) {
        getCOSDictionary().setItem(COSName.PG, (COSObjectable) pDPage);
    }

    public void setParent(PDStructureNode pDStructureNode) {
        getCOSDictionary().setItem(COSName.P, (COSObjectable) pDStructureNode);
    }

    public void setRevisionNumber(int i) {
        if (i >= 0) {
            getCOSDictionary().setInt(COSName.R, i);
            return;
        }
        throw new IllegalArgumentException("The revision number shall be > -1");
    }

    public void setStructureType(String str) {
        getCOSDictionary().setName(COSName.S, str);
    }

    public void setTitle(String str) {
        getCOSDictionary().setString(COSName.T, str);
    }

    public void appendKid(PDMarkedContentReference pDMarkedContentReference) {
        appendObjectableKid(pDMarkedContentReference);
    }

    public void insertBefore(PDMarkedContentReference pDMarkedContentReference, Object obj) {
        insertObjectableBefore(pDMarkedContentReference, obj);
    }

    public void removeKid(PDMarkedContentReference pDMarkedContentReference) {
        removeObjectableKid(pDMarkedContentReference);
    }

    public void appendKid(PDObjectReference pDObjectReference) {
        appendObjectableKid(pDObjectReference);
    }

    public void insertBefore(PDObjectReference pDObjectReference, Object obj) {
        insertObjectableBefore(pDObjectReference, obj);
    }

    public void removeKid(PDObjectReference pDObjectReference) {
        removeObjectableKid(pDObjectReference);
    }

    public PDStructureElement(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}

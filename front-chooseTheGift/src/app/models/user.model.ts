import { ParentEntity } from './parentEntity.model';

export class UserModel extends ParentEntity {
    public firstname: string;
    public lastname: string;
    public money: number;
}